package ui;

import java.util.Scanner;

public class InputOutputUtil {
	private final Scanner scanner;

	public InputOutputUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public void printError(String message) {
		printError();
		System.out.println(message);
	}

	public void printError() {
		System.out.println("에러입니다.");
	}

	public String nextInput() throws Exception {
		System.out.print("숫자를 입력해주세요 : ");
		return scanner.next();
	}

	public int restartGame() throws Exception {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return Integer.valueOf(scanner.next());
	}

	public void endGame() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private void printStrike(int strike) {
		System.out.print(strike + " 스트라이크 ");
	}

	private void printBall(int ball) {
		System.out.print(ball + " 볼 ");
	}

	private void printNothing() {
		System.out.print("낫싱");
	}

	private void printLineChange() {
		System.out.println();
	}

	public void printStatus(int strike, int ball) {
		if (ball == 0 && strike == 0) {
			printNothing();
		}
		if (strike != 0) {
			printStrike(strike);
		}
		if (ball != 0) {
			printBall(ball);
		}

		printLineChange();
	}
}
