package controller;

import model.Balls;
import model.BaseBallGameResult;
import model.RandomBallNumberGenerator;
import view.InputView;
import view.OutputView;

public class BaseBallGame {

	private static final int RESTART_NUMBER_FLAG = 1;
	private static boolean isRestart = true;

	public void gameStart() {
		RandomBallNumberGenerator randomBallNumberGenerator = new RandomBallNumberGenerator();

		while (isRestart) {
			BaseBallGameResult baseBallGameResult = new BaseBallGameResult(
				new Balls(randomBallNumberGenerator.getRandomBallNumbers()),
				new Balls(InputView.scannerUserInputNumber()));

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
