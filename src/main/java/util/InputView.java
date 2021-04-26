package util;

import java.util.Scanner;

public class InputView {
	private static Scanner input = new Scanner(System.in);
	private static final String MESSAGE_GET_ANSWER = "숫자를 입력해주세요 : ";
	private static final String MESSAGE_RESTART_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	// 사용자의 정답 입출력 기능
	public static String getAnswer() {
		System.out.print(MESSAGE_GET_ANSWER);
		return input.nextLine();
	}

	// 결과 게임 종료 입출력 기능
	public static String restartOrNot() {
		System.out.println(MESSAGE_RESTART_GAME);
		return input.nextLine();
	}
}
