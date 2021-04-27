package utils;

import java.util.Scanner;

public class IoUtils {
	public static String input() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static void output(String inputText) {
		System.out.println(inputText);
	}
}
