package service;

import java.util.Scanner;

import domain.Computer;
import domain.Referee;
import domain.User;
import vo.BaseballResult;

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
			this.play();
		}
	}

	private void play() {
		BaseballResult baseballResult = referee.discriminate(this.computer.getNumber(), this.user.getNumber());
		System.out.println(this.computer.getNumber());
		this.printResult(baseballResult);
	}

	private void printResult(BaseballResult baseballResult) {
		if (baseballResult.isNothing()) {
			System.out.println("낫싱");
			return;
		}

		System.out.println(makeStrikeBallResultOutput(baseballResult));
	}

	private StringBuilder makeStrikeBallResultOutput(BaseballResult baseballResult) {
		StringBuilder message = new StringBuilder();

		if (baseballResult.getStrikeCount() > 0) {
			message.append(String.format("%d 스트라이크", baseballResult.getStrikeCount()));
		}

		if (message.length() > 0) {
			message.append(" ");
		}

		if (baseballResult.getBallCount() > 0) {
			message.append(String.format("%d볼", baseballResult.getBallCount()));
		}
		return message;
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
