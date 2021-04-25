package baseball.ui.impl;

import java.util.Scanner;

import baseball.ui.UiSystem;

public class ConsoleUiSystem implements UiSystem {
	private boolean debug = true;
	private final Scanner scanner = new Scanner(System.in);

	// check validation
	@Override
	public String gameInput() {
		return scanner.nextLine();
	}

	@Override
	public String systemInput() {
		return scanner.nextLine();
	}

	@Override
	public void display(String data) {
		System.out.println(data);
	}

	@Override
	public void debug(String data) {
		if (debug) {
			System.out.println(data);
		}
	}

}
