package baseball.view;

import baseball.domain.Game;
import baseball.domain.Result;

import java.io.Closeable;
import java.io.IOException;
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
	public void showHint(Result result) {
		String message = makeHint(result);
		System.out.println(message);
	}

	private String makeHint(Result result) {
		if(result.isNothing()) {
			return Constants.HINT_NOTHING;
		}

		StringBuilder builder = new StringBuilder();
		if(result.strike > 0) {
			builder.append(String.format(Constants.HINT_STRIKE, result.strike));
		}

		if(result.ball > 0) {
			builder.append(String.format(Constants.HINT_BALL, result.ball));
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
