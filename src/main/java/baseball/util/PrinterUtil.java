package baseball.util;

import baseball.enums.Message;

public class PrinterUtil {

	public static void printInPut() {
		System.out.print(Message.INPUT_NUM.getMessage());
	}

	public static void printGameEnd() {
		System.out.println(Message.GAME_END.getMessage());
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printReGame() {
		System.out.println(Message.RE_GAME.getMessage());
	}
}
