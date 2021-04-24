package display;

import java.util.Scanner;

public class Display {
	private final Scanner scanner;

	public Display() {
		this.scanner = new Scanner(System.in);
	}

	public void expose(String input) {
		System.out.print(input);
	}

	public void input() {
		scanner.nextInt();
	}
}
