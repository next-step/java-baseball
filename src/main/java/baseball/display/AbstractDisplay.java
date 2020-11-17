package baseball.display;

import java.io.PrintStream;

import baseball.report.Report;

public abstract class AbstractDisplay implements Display {
	private String askMessage;
	private String endMessage;
	private String restartMessage;
	private PrintStream printStream = System.out;

	public AbstractDisplay() {
		this.askMessage = "숫자를 입력해 주세요 : ";
		this.endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
		this.restartMessage = "게임을 새로 시작하려면 1,종료하려면 2를 입력하세요 : ";
	}

	public AbstractDisplay(PrintStream printStream) {
		this();
		this.printStream = printStream;
	}

	public AbstractDisplay(String askMessage, String endMessage, String restartMessage) {
		this.askMessage = askMessage;
		this.endMessage = endMessage;
		this.restartMessage = restartMessage;
	}

	public void resultMessage(Report report) {
		reportMessage(report);
		if (report.isStrikeOut()) {
			endMessage();
		}
	}

	void print(String message) {
		this.printStream.print(message);
	}

	void println(String message) {
		this.printStream.println(message);
	}

	public String getAskMessage() {
		return askMessage;
	}

	public String getEndMessage() {
		return endMessage;
	}

	public String getRestartMessage() {
		return restartMessage;
	}

	abstract void endMessage();

	abstract void reportMessage(Report report);
}
