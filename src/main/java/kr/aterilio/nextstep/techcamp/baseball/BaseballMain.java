package kr.aterilio.nextstep.techcamp.baseball;

import kr.aterilio.nextstep.techcamp.baseball.ui.InputView;
import kr.aterilio.nextstep.techcamp.baseball.ui.ResultView;

import java.util.Collections;
import java.util.List;

public class BaseballMain {

	public static void main(String[] args) {

		BaseballMain main = new BaseballMain();

		InputView inputView = new InputView();
		inputView.welcome();

		main.play(inputView);
	}

	private void play(InputView inputView) {

		BaseballGame baseballGame = new BaseballGame();
		baseballGame.create();

		if (!baseballGame.isCreateSuccess()) {
			return;
		}

		List<Integer> inputs = Collections.emptyList();

		do {
			inputs = inputView.trying();

			ResultView resultView = new ResultView();
			resultView.printResult(baseballGame.judge(inputs));
		} while (inputs.size() != baseballGame.getGameSize());

		// for debug
		baseballGame.printBoard();
	}
}
