package jbh.view;

import java.util.Scanner;

import jbh.numberbaseball.GameResult;

public class BaseballUI {

	private final Scanner scanner = new Scanner(System.in);

	public String getUserInputText() {
		return scanner.nextLine().trim();
	}

	public void displayInputRequestMessage() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public void displayEndingMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public void displayMenu() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void displayGameResult(GameResult result) {
		if (result.isNothing()) {
			System.out.println("낫싱");
			return;
		}
		displayPitchingCountResult(result);
	}

	private void displayPitchingCountResult(GameResult result) {
		if (result.hasStrike()) {
			System.out.printf("%d 스트라이크 ", result.getStrikeCount());
		}
		if (result.hasBall()) {
			System.out.printf("%d 볼 ", result.getBallCount());
		}
		System.out.println("");
	}
}
