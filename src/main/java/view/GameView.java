package view;

import java.util.Scanner;

import dto.GameResult;
import validator.NumberValidator;

public class GameView {
	private static final NumberValidator numberValidator = new NumberValidator();

	public static String inputNumberView() {
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

	public static boolean endView() {
		Scanner scanner = new Scanner(System.in);
		String inputNumber;
		do {
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			inputNumber = scanner.nextLine();
		} while (numberValidator.isNotValidEndViewInput(inputNumber));
		return inputNumber.charAt(0) == '1';
	}

}
