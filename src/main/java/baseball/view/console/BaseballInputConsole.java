package baseball.view.console;

import baseball.controller.dto.EndGameRequest;
import baseball.controller.dto.GuessNumberRequest;
import baseball.view.BaseballInput;

public class BaseballInputConsole implements BaseballInput {
	@Override
	public GuessNumberRequest getGuessNumberRequest() {
		// TODO: implement getting guess number from user by console
		return null;
	}

	@Override
	public EndGameRequest getEndGameRequest() {
		// TODO: implement getting end game  action from user by console
		return null;
	}
}
