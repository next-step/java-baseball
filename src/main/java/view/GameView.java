package view;

import java.util.Scanner;

import dto.GameResult;
import validator.NumberValidator;

public class GameView {
	public static String inputNumberView() {
		NumberValidator numberValidator = new NumberValidator();
		Scanner scanner = new Scanner(System.in);
		String inputNumber;
		do {
			System.out.print("숫자를 입력해주세요: ");
			inputNumber = scanner.nextLine();
		} while (!numberValidator.validate(inputNumber));
		return inputNumber;
	}

	public static boolean resultView(GameResult gameResult) {
		System.out.println(gameResult.getMsg());
		return gameResult.getSuccessFlag();
	}
}
