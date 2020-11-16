package baseball.controller;

import baseball.controller.dto.EndGameRequest;
import baseball.controller.dto.GuessFeedbackResponse;
import baseball.controller.dto.GuessNumberRequest;
import baseball.model.BaseballGameService;
import baseball.view.BaseballInput;
import baseball.view.BaseballOutput;

public class BaseballController {
	private BaseballInput input;
	private BaseballOutput output;
	private BaseballGameService baseballGameService;

	private BaseballController(BaseballInput input, BaseballOutput output) {
		this.input = input;
		this.output = output;
	}

	public static BaseballController of(BaseballInput input, BaseballOutput output) {
		return new BaseballController(input, output);
	}

	public void run() {
		do {
			baseballGameService = BaseballGameService.ofRandom();
			playBaseballGame();
		} while (input.getEndGameRequest().getAction() == EndGameRequest.Action.RESTART);
	}

	private void playBaseballGame() {
		do {
			GuessNumberRequest request = input.getGuessNumberRequest();
			GuessFeedbackResponse response = baseballGameService.guessNumber(request);
			output.returnGuessFeedbackResponse(response);
		} while (!baseballGameService.hasCorrectGuess());
	}
}
