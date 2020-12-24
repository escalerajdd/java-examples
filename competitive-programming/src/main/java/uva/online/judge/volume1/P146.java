package uva.online.judge.volume1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//146 - ID Codes
public class P146 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()).compareTo("#") != 0) {
			System.out.println(getSuccessor(input.toCharArray()));
		}
	}

	private static String getSuccessor(char[] input) {
		int min;
		String code = new String(input);
		for (int i = input.length - 1; i > 0; i--) {
			if (input[i] > input[i - 1]) {
				min = i;
				String result = code.substring(0, i - 1);
				for (int j = i + 1; j < input.length; j++)
					if (input[j] < input[i] && input[j] > input[i - 1])
						min = j;
				result += input[min];
				char[] auxArray = (code.substring(i - 1, min) + code.substring(min + 1, code.length())).toCharArray();
				Arrays.sort(auxArray);
				return result + new String(auxArray);
			}
		}
		return "No Successor";
	}

}