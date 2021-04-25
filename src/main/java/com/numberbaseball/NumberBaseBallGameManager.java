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
			startGames(sc);
		}
	}

	private void startGames(Scanner sc) {
		do {
			startGame(sc);

			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
		} while (isContinue(sc.nextInt()));
	}

	private void startGame(Scanner sc) {
		int answer = numberCreator.createEachNumberIsUniqueThreeDigitNumber();

		NumberBaseBallResult result;
		do {
			System.out.print("숫자를 입력해주세요 : ");

			result = compareInputWithAnswer(sc.nextInt(), answer);
		} while (!result.isThreeStrike());
	}

	private NumberBaseBallResult compareInputWithAnswer(int input, int answer) {
		NumberBaseBallResult result;

		result = numberBaseBallGame.toResult(answer, input);

		System.out.println(result.toStr());
		return result;
	}

	private boolean isContinue(int input) {
		return input == 1;
	}
}
