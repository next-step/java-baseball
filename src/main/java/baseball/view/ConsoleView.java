package baseball.view;

import baseball.domain.Game;
import baseball.domain.Hint;

import java.io.*;
import java.util.Scanner;

public class ConsoleView implements View, Closeable {

	private final Scanner scanner;

	public ConsoleView() {
		scanner = new Scanner(System.in);
	}

	@Override
	public void showInputNumberMessage() {
		System.out.print(Constants.MESSAGE_INPUT_NUMBER);
	}

	@Override
	public void showEndGameMessage() {
		System.out.println(String.format(Constants.MESSAGE_END_GAME, Game.NUMBER_LENGTH));
	}

	@Override
	public void showRestartGameMessage() {
		System.out.println(Constants.MESSAGE_RESTART_GAME);
	}

	@Override
	public void showHint(Hint hint) {
		String message = makeHintText(hint);
		System.out.println(message);
	}

	private String makeHintText(Hint hint) {
		if(hint.strike == 0 && hint.ball == 0) {
			return Constants.HINT_NOTHING;
		}

		StringBuilder builder = new StringBuilder();
		if(hint.strike > 0) {
			builder.append(String.format(Constants.HINT_STRIKE, hint.strike));
		}

		if(hint.ball > 0) {
			builder.append(String.format(Constants.HINT_BALL, hint.ball));
		}
		return builder.toString();
	}

	@Override
	public String readInput() {
		return scanner.next();
	}

	@Override
	public void close() throws IOException {
		scanner.close();
	}
}
