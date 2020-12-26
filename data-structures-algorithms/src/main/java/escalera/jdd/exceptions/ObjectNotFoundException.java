package escalera.jdd.exceptions;

public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException() {
		super("Object not found in collection.");
	}

}
