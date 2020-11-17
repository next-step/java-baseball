package study;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int input;

		do {
			BaseballGame baseballGame = new BaseballGame();
			baseballGame.start();
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = scanner();
		} while (input != 2);
	}

	public static int scanner() {
		int input;

		try {
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextInt();
			if (input != 1 && input != 2) {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			System.out.println("값은 1 또는 2 만 입력할수 있습니다. 다시 입력해주세요.");
			return scanner();
		}
		return input;
	}
}
