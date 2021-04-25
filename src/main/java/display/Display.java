package display;

import java.util.Scanner;

import baseballnumber.BaseballNumberBoard;

public class Display {
	private final Scanner scanner;

	public Display() {
		this.scanner = new Scanner(System.in);
	}

	public void expose(String input) {
		System.out.print(input);
	}

	public void exposeGameEnd() {
		System.out.println("게임이 종료되었습니다");
	}

	public void exposeRetry() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public int input() {
		return scanner.nextInt();
	}

	public void exposeGameScore(BaseballNumberBoard numberBoard) {

	}
}
