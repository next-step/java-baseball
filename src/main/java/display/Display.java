package display;

import java.util.Scanner;

import baseballnumber.BaseballNumberBoard;

public class Display {
	private final Scanner scanner;

	public Display() {
		this.scanner = new Scanner(System.in);
	}

	public void exposeGameEnd() {
		System.out.println("게임이 종료되었습니다");
	}

	public void exposeInputRetry() {
		System.out.println("잘못된 값을 입력하셨습니다. 값은 세 자리여야 하고, 각 자리수는 서로 다른 값이어야 합니다");
	}

	public void exposeInputRestart() {
		System.out.println("1 또는 2만 입력하셔야 합니다.");
	}

	public void exposeEndMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void exposeCheckRetry() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
	}

	public void exposeQuestion() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public String input() {
		return scanner.next();
	}

	public void exposeGameScore(BaseballNumberBoard numberBoard) {
		if (numberBoard.isNothing()) {
			System.out.println("낫싱");
			return;
		}

		String matchedPointMessage = buildGameScoreMessage(numberBoard.getStrike(), " 스트라이크 ")
			+ buildGameScoreMessage(numberBoard.getBall(), " 볼");
		System.out.println(matchedPointMessage);
	}

	private String buildGameScoreMessage(int score, String description) {
		String result = "";
		if (score != 0) {
			result += score;
			result += description;
		}

		return result;
	}

	public void exposeNumberError() {
		System.out.println("숫자만 입력해 주세요");
	}
}
