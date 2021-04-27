package baseball.view;

import baseball.domain.Hint;

public interface View {
	void showInputNumberMessage();

	void showEndGameMessage();

	void showRestartGameMessage();

	void showHint(Hint hint);

	String readInput();
}
