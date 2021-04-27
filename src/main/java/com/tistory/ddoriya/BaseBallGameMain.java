/*
 * @(#) beseBallGameMain.java 2021. 04. 23.
 *
 */
package com.tistory.ddoriya;

import java.util.Scanner;

/**
 * @author 이상준
 */
public class BaseBallGameMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		playGame(scanner);

		while (true) {
			String input = scanner.nextLine();
			if (!BaseBallGameValidator.isInputGameStatusValid(input)) {
				System.out.println("형식이 잘못되었습니다. 다시입력해주세요.");
				continue;
			}

			if ("1".equals(input)) {
				playGame(scanner);
			} else if ("2".equals(input)) {
				break;
			}
		}

		scanner.close();
	}

	private static void playGame(Scanner scanner) {
		BaseBallGameService baseBallGameService = new BaseBallGameService();

		while (!baseBallGameService.isGameCompleted()) {
			try {
				System.out.print("숫자를 입력해주세요 : ");
				baseBallGameService.executeGame(scanner.nextLine());
				System.out.println(baseBallGameService.getGameMessage());
			} catch (NumberFormatException ne) {
				System.out.println(ne.getMessage());
			}
		}
		System.out.println("3개 숫자를 모두 맞추셨습니다! 게임종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
