package baseball.display;

import java.io.PrintStream;

import baseball.report.Report;

public class DefaultDisplay extends AbstractDisplay {
	public DefaultDisplay(PrintStream printStream) {
		super(printStream);
	}

	@Override
	public void askMessage() {
		print(this.getAskMessage());
	}

	@Override
	public void endMessage() {
		println(this.getEndMessage());
	}

	@Override
	void reportMessage(Report report) {
		println(report.toString());
	}

	@Override
	public void restartMessage() {
		print(this.getRestartMessage());
	}

	@Override
	public void errorMessage(String errorMessage) {
		println(errorMessage);
	}

}
