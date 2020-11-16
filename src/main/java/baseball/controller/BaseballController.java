package baseball.controller;

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
		baseballGameService = new BaseballGameService();
	}

	public static BaseballController of(BaseballInput input, BaseballOutput output) {
		return new BaseballController(input, output);
	}

	public void run() {
		// TODO: implement activity flow of the baseball game
	}
}
