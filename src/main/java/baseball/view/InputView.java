package baseball.view;

import java.util.Scanner;

public class InputView {
	private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요: ";
	private static final String GAME_CHOICE_MESSAGE = "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요: ";

	public static String getUserAnswer() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(INPUT_NUMBER_MESSAGE);
		return scanner.nextLine();
	}

	public static int getGameChoice() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(GAME_CHOICE_MESSAGE);
		return scanner.nextInt();
	}
}
