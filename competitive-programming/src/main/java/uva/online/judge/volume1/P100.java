package uva.online.judge.volume1;

import java.io.IOException;
import java.util.Scanner;

//100 - The 3n+1 Problem
public class P100 {

	public static void main(String[] args) throws IOException {
		try {
			Scanner sc = new Scanner(System.in);
			while (sc.hasNext()) {
				System.out.println(getMaxCycleLength(sc.nextLong(), sc.nextLong()));
			}
		} catch (Exception e) {
		} finally {
			System.exit(0);
		}
	}

	private static String getMaxCycleLength(long first, long second) {
		int max = 0;
		for (long i = Math.min(first, second); i <= Math.max(first, second); i++) {
			max = Math.max(max, getCycleLength(i));
		}
		return String.format("%d %d %d", first, second, max);
	}

	private static int getCycleLength(long num) {
		int length = 1;
		while (num != 1) {
			if (num % 2 == 0)
				num /= 2;
			else
				num = num * 3 + 1;
			length++;
		}
		return length;
	}

}