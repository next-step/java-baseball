package view;

import java.io.PrintStream;

import number.NumbersMatchResult;

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

	public void printNumbersMatchResult(NumbersMatchResult numbersMatchResult,
		NumberMatchResultRenderer numberMatchResultRenderer) {
		final String resultMessage = numberMatchResultRenderer.render(numbersMatchResult);
		printStream.println(resultMessage);
	}

	public void printEndGameMessage(int numberLength) {
		String message = String.format(GAME_OVER_MESSAGE_FORMAT, numberLength);
		printStream.println(message);
	}

	public void printRerunGameMessage(String rerunFlag, String endFlag) {
		String message = String.format(GAME_RERUN_MESSAGE_FORMAT, rerunFlag, endFlag);
		printStream.println(message);
	}
}

