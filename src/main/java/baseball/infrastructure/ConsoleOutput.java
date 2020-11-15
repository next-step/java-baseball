package baseball.infrastructure;

import java.io.PrintStream;

public class ConsoleOutput {

	private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String GAME_ROUND_END_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String GAME_CONTINUE_MESSAGE = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.";
	private static final String GAME_END_MESSAGE = "게임이 종료되었습니다.";
	private static final int GAME_NUMBER_SIZE = 3;
	private static final int GAME_CONTINUE = 1;
	private static final int GAME_END = 2;

	private static final PrintStream CONSOLE = System.out;

	public static void printInputNumber() {
		CONSOLE.print(NUMBER_INPUT_MESSAGE);
	}

	public static void printRoundEnd() {
		CONSOLE.printf((GAME_ROUND_END_MESSAGE) + "%n", GAME_NUMBER_SIZE);
	}

	public static void printContinue() {
		CONSOLE.printf((GAME_CONTINUE_MESSAGE) + "%n", GAME_CONTINUE, GAME_END);
	}

	public static void printMessage(String message) {
		CONSOLE.println(message);
	}

	public static void printEndGame() {
		CONSOLE.println(GAME_END_MESSAGE);
	}
}
