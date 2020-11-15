package baseball;

import static baseball.infrastructure.ConsoleInput.*;
import static baseball.infrastructure.ConsoleOutput.*;

import baseball.domain.Answerer;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballResult;
import baseball.domain.Computer;
import baseball.domain.Gamer;
import baseball.domain.Questioner;
import baseball.util.RandomNumberGenerator;

public class BaseballGameLauncher {
	private static final int END_NUMBER = 2;

	public static void main(String[] args) {

		boolean isContinued = true;
		while (isContinued) {
			Questioner questioner = Computer.of(new RandomNumberGenerator());
			Answerer answerer = Gamer.of(questioner);

			gameRoundRunner(answerer);

			printRoundEnd();
			printContinue();
			isContinued = isContinued();
		}

		printEndGame();
	}

	private static boolean isContinued() {
		return inputStringToInt() != END_NUMBER;
	}

	private static void gameRoundRunner(Answerer answerer) {
		boolean isRoundContinued;
		do {
			printInputNumber();
			final BaseballResult baseballResult =
				answerer.playGame(BaseballNumbers.of(inputStringToIntegerList()));
			printMessage(baseballResult.getResultMessage());
			isRoundContinued = !baseballResult.isOut();
		} while (isRoundContinued);
	}
}
