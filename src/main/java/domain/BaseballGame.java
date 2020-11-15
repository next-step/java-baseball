package domain;

import java.util.Scanner;

import utils.BaseballUtils;

public class BaseballGame {
	private static final Scanner scanner = new Scanner(System.in);

	public static void processGame() {
		BaseballAnswer baseballAnswer = new BaseballAnswer();
		baseballAnswer.makeAnswer();
		boolean isEndGame = false;

		while (!isEndGame) {
			isEndGame = checkWithAnswer(baseballAnswer, scanUserInput());
		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
	}

	public static String scanUserInput() {
		boolean isValid = false;
		String inputString = "";

		while (!isValid) {
			System.out.print("숫자를입력해주세요 : ");
			inputString = scanner.nextLine();
			isValid = BaseballUtils.isValidInput(inputString);
		}
		return inputString;
	}

	public static boolean checkWithAnswer(BaseballAnswer answer, String userInput) {
		answer.checkAnswer(userInput.toCharArray());
		return answer.isExactlyAnswer();
	}
}
