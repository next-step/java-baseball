package view;

import java.io.PrintStream;

import number.HintsCount;

public class PrintStreamOutputView implements OutputView {

	private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String GAME_OVER_MESSAGE_FORMAT = "%s개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String GAME_RERUN_MESSAGE_FORMAT = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.";

	private final PrintStream printStream;

	public PrintStreamOutputView(PrintStream printStream) {
		this.printStream = printStream;
	}

	public void printInputNumberMessage() {
		printStream.print(INPUT_NUMBERS_MESSAGE);
	}

	public void printHints(HintsCount hintsCount, HintsCountRenderer hintsCountRenderer) {
		final String hintsMessage = hintsCountRenderer.render(hintsCount);
		printStream.println(hintsMessage);
	}

	public void printEndGameMessage(int numberLength) {
		final String message = String.format(GAME_OVER_MESSAGE_FORMAT, numberLength);
		printStream.println(message);
	}

	public void printNewGameMessage(String restartCommand, String endCommand) {
		final String restartMessage = String.format(GAME_RERUN_MESSAGE_FORMAT, restartCommand, endCommand);
		printStream.println(restartMessage);
	}
}

