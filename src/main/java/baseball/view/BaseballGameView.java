package baseball.view;

import baseball.GameResult;

public interface BaseballGameView {

	void showBallCountMessage(GameResult result);

	void showAskingForInputMessage();

	boolean showFinishMessage(boolean roundFinished);
}
