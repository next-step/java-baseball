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
		do {
			main.play(inputView);
		} while(inputView.isContinue());
	}

	private void play(InputView inputView) {
		BaseballGame baseballGame = new BaseballGame();
		baseballGame.create();
		if (!baseballGame.isCreateSuccess()) {
			return;
		}
		guess(inputView, baseballGame);
	}

	private void guess(InputView inputView, BaseballGame baseballGame) {
		BaseballResult baseballResult = null;
		do {
			List<Integer> inputs = input(inputView, baseballGame.getGameSize());
			baseballResult = baseballGame.judge(inputs);
			printResult(baseballResult);
		} while(!baseballResult.isGameOver());
		ResultView.printGameOver();
	}

	private List<Integer> input(InputView inputView, int gameSize) {
		List<Integer> inputs = Collections.emptyList();
		do {
			inputs = inputView.read();
		} while (inputs.size() != gameSize);
		return inputs;
	}

	private void printResult(BaseballResult baseballResult) {
		if (baseballResult != null && !baseballResult.isFailed()) {
			ResultView resultView = new ResultView();
			resultView.printResult(baseballResult);
		}
	}
}
