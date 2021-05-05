package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static Scanner SCANNER = new Scanner(System.in);

	public static List<Integer> scannerUserInputNumber() {
		System.out.print("숫자를 입력해 주세요 : ");
		String userInputNumber = SCANNER.next();

		return stringToListConvert(userInputNumber);
	}

	public static int scannerRestartOrEndNumber() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		return SCANNER.nextInt();
	}

	public static List<Integer> stringToListConvert(String userInputNumber) {
		List<Integer> userInputList = new ArrayList<>();

		for (int i = 0; i < userInputNumber.length(); i++) {
			userInputList.add(Character.getNumericValue(userInputNumber.charAt(i)));
		}

		return userInputList;
	}
}
