package service;

import java.util.Scanner;

import domain.Computer;
import domain.Referee;
import domain.User;

public class BaseballGame {

	private Computer computer;
	private User user;
	private Scanner scanner;
	private Boolean isGameEnd;
	private Referee referee;

	public void start() {
		this.initialize();

		while (!this.isGameEnd) {
			this.setPlayers();
			this.inputUserNumber();
		}
	}

	private void inputUserNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		Integer inputNumber = scanner.nextInt();
		user.changeNumber(inputNumber);
	}

	private void initialize() {
		scanner = new Scanner(System.in);
		isGameEnd = false;
		referee = new Referee();
	}

	private void setPlayers() {
		this.computer = new Computer();
		this.user = new User();
	}
}
