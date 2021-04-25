package com.numberbaseball;

import java.util.Scanner;

public class NumberBaseBallGameManager {
	private NumberCreator numberCreator;
	private NumberBaseBallGame numberBaseBallGame;

	public NumberBaseBallGameManager() {
		this.numberCreator = new NumberCreator();
		this.numberBaseBallGame = new NumberBaseBallGame();
	}

	public void start() {
		try (Scanner sc = new Scanner(System.in)) {
			do {
				int answer = numberCreator.createEachNumberIsUniqueThreeDigitNumber();
				NumberBaseBallResult result;
				do {
					System.out.print("숫자를 입력해주세요 : ");
					result = numberBaseBallGame.toResult(answer, sc.nextInt());
					System.out.println(result.toStr());
				} while (!result.isThreeStrike());

				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
					+ "게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");

			} while (isContinue(sc.nextInt()));
		}
	}

	private boolean isContinue(int input) {
		return input == 1;
	}
}
