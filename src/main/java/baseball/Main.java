package baseball;

import baseball.domain.BaseballGame;
import baseball.view.InputView;

public class Main {

	public static void main(String[] args) {
		do {
			BaseballGame.play();
		} while (InputView.inputReplayBaseBallGame());
	}

}
