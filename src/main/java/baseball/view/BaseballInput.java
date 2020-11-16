package baseball.view;

import baseball.controller.dto.EndGameRequest;
import baseball.controller.dto.GuessNumberRequest;

public interface BaseballInput {
	GuessNumberRequest getGuessNumberRequest();
	EndGameRequest getEndGameRequest();
}
