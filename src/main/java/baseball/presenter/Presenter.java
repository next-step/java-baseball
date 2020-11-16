package baseball.presenter;

import baseball.game.GameScore;

public interface Presenter {

	void operate();
	void exit();
	void startGame();
	void playBall();
	void inputFailed(String cause);
	void score(GameScore score);
	void clear();
}
