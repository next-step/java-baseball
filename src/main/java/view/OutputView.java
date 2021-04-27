package view;

import number.HintsCount;

public interface OutputView {
	void printInputNumberMessage();

	void printHints(HintsCount hintsCount, HintsCountRenderer hintsCountRenderer);

	void printEndGameMessage(int numberLength);

	void printNewGameMessage(String restartCommand, String endCommand);
}
