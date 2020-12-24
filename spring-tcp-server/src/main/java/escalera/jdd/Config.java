package escalera.jdd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.ip.tcp.TcpInboundGateway;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpNetServerConnectionFactory;
import org.springframework.messaging.MessageChannel;

@EnableIntegration
@IntegrationComponentScan
@Configuration
public class Config {

	@Value(value = "${tcp.server.port}")
	private int port;

	@Bean
	public AbstractServerConnectionFactory serverConnectionFactory() {
		AbstractServerConnectionFactory connectionFactory = new TcpNetServerConnectionFactory(this.port);
		connectionFactory.setSingleUse(true);
		return connectionFactory;
	}

	@Bean
	public TcpInboundGateway tcpInGate(AbstractServerConnectionFactory serverConnectionFactory) {
		TcpInboundGateway inGate = new TcpInboundGateway();
		inGate.setConnectionFactory(serverConnectionFactory);
		inGate.setRequestChannel(fromTcp());
		return inGate;
	}

	@Bean
	public MessageChannel fromTcp() {
		return new DirectChannel();
	}

	@MessageEndpoint
	public static class Echo {

		@Transformer(inputChannel = "fromTcp", outputChannel = "toEcho")
		public String convert(byte[] bytes) {
			return new String(bytes);
		}

		@ServiceActivator(inputChannel = "toEcho")
		public String upCase(String in) {
			return in.toUpperCase();
		}

	}

}