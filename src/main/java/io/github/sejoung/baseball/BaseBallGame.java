package io.github.sejoung.baseball;

public class BaseBallGame {
	private static final String NEW_LINE = System.lineSeparator();

	private static final String INPUT_MESSAGE = "숫자를 입력해주세요: ";

	private final StringBuffer output;

	public BaseBallGame(BaseBallNumberGenerator generator) {
		this.output = new StringBuffer(INPUT_MESSAGE);
	}

	public boolean isCompleted() {
		return false;
	}

	public String flushOutput() {
		String message = output.toString();
		output.setLength(0);
		return message;
	}

	public void processInput(String input) {
		if (input.length() != 3) {
			output.append("3 자리수만 입력 가능합니다.");
			output.append(NEW_LINE);
			output.append(INPUT_MESSAGE);
		}
	}
}
