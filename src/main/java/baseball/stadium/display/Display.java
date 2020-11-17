package baseball.stadium.display;

import baseball.stadium.report.Report;

public interface Display {
	void askMessage();

	void resultMessage(Report report);

	void restartMessage();

	void errorMessage(String errorMessage);
}
