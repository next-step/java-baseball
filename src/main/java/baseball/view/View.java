package baseball.view;

import baseball.domain.Result;

public interface View {
	void showInputNumberMessage();

	void showEndGameMessage();

	void showRestartGameMessage();

	void showHint(Result result);

	String readInput();
}
