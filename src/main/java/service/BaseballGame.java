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
			this.inputUserNumber();
			this.play();
		}
	}

	private void initialize() {
		this.scanner = new Scanner(System.in);
		this.isGameEnd = false;
		this.referee = new Referee();
		this.setPlayers();
	}

	private void setPlayers() {
		this.computer = new Computer();
		this.user = new User();
	}

	private void inputUserNumber() {
		System.out.print("숫자를 입력해주세요 : ");
		Integer inputNumber = scanner.nextInt();
		user.changeNumber(inputNumber);
	}

	private void play() {
		BaseballResult baseballResult = referee.discriminate(this.computer.getNumber(), this.user.getNumber());
		this.printResult(baseballResult);

		if (baseballResult.getStrikeCount() == 3) {
			this.endGame();
		}
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

	private void endGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		Integer input = scanner.nextInt();

		if (input.equals(1)) {
			this.setPlayers();
			return;
		}

		if (input.equals(2)) {
			this.isGameEnd = true;
		}

	}

}
