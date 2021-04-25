package view;

import java.util.Scanner;

import util.GameUtil;

public class GameView {
	public static void inputNumberView() {
		Scanner scanner = new Scanner(System.in);
		String inputNumber;
		do {
			System.out.print("숫자를 입력해주세요: ");
			inputNumber = scanner.nextLine();
		} while (!GameUtil.validateNumberFormat(inputNumber));
	}
}
