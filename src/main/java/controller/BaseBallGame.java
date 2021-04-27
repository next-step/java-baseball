package controller;

import model.BaseBallGameResult;
import model.RandomBallNumbers;
import model.UserBallNumbers;
import view.InputView;
import view.OutputView;

public class BaseBallGame {

	private static final int RESTART_NUMBER_FLAG = 1;
	private static boolean isRestart = true;

	public void gameStart() {
		RandomBallNumbers randomBallNumbers = new RandomBallNumbers();

		while (isRestart) {
			BaseBallGameResult baseBallGameResult = new BaseBallGameResult(randomBallNumbers,
				new UserBallNumbers(InputView.scannerUserInputNumber()));

			answerCheck(baseBallGameResult);
		}

	}

	private void answerCheck(BaseBallGameResult baseBallGameResult) {
		if (baseBallGameResult.isAnswer()) {
			restartOrEnd();
			return;
		}

		OutputView.printBaseBallGameResult(baseBallGameResult);
	}

	private void restartOrEnd() {
		if (InputView.scannerRestartOrEndNumber() == RESTART_NUMBER_FLAG) {
			gameStart();
		}

		isRestart = false;
	}
}
