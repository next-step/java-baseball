package view;

import java.util.Scanner;

import dto.GameResult;
import validator.NumberValidator;

/**
 * UI 로직을 관리하는 클래스
 */
public class GameView {
	private static final NumberValidator numberValidator = new NumberValidator();

	// 사용자로부터 수 입력 화면
	public static String inputNumberView() {
		Scanner scanner = new Scanner(System.in);
		String inputNumber;
		do {
			System.out.print("숫자를 입력해주세요: ");
			inputNumber = scanner.nextLine();
		} while (!numberValidator.validate(inputNumber));
		return inputNumber;
	}

	// 사용자의 입력한 수에 대한 결과 출력 화면
	public static boolean resultView(GameResult gameResult) {
		System.out.println(gameResult.getMsg());
		return gameResult.getSuccessFlag();
	}

	// 게임에 이겼을 때 이 후의 선택지 결과 화면
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
