package ttuop.nextstep.baseball;

import java.util.Scanner;

class UserInterface {

	private static final Scanner SCANNER = new Scanner(System.in);

	static String receive() {
		return SCANNER.nextLine();
	}

	static void send(final String output) {
		System.out.println(output);
	}

	static void shutdown() {
		SCANNER.close();
	}
}
