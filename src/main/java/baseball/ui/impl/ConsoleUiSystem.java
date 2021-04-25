package baseball.ui.impl;

import java.util.Scanner;

import baseball.ui.UiSystem;

public class ConsoleUiSystem implements UiSystem {
	private final Scanner scanner = new Scanner(System.in);

	public ConsoleUiSystem() {
		this.display("ui console");
	}

	@Override
	public Integer gameInput() {
		return scanner.nextInt();
	}

	@Override
	public String systemInput() {
		return scanner.nextLine();
	}

	@Override
	public void display(String data) {
		System.out.println(data);
	}

}
