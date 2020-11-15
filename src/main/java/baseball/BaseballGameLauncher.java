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
	public static void main(String[] args) {

		boolean isContinued = true;
		while (isContinued) {
			Questioner questioner = Computer.of(new RandomNumberGenerator());
			Answerer answerer = Gamer.of(questioner);

			boolean isRoundContinued = true;
			while (isRoundContinued) {
				printInputNumber();
				final BaseballResult baseballResult =
					answerer.playGame(BaseballNumbers.of(inputStringToIntegerList()));
				printMessage(baseballResult.getResultMessage());
				if (baseballResult.isOut()) {
					isRoundContinued = false;
				}
			}

			printRoundEnd();
			printContinue();
			if (inputStringToInt() == 2) {
				isContinued = false;
			}
		}

		printEndGame();
	}
}
