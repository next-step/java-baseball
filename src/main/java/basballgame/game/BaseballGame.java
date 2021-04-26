package basballgame.game;

import basballgame.ui.input.BaseballNumberInput;
import basballgame.ui.output.Output;

public class BaseballGame {

	private final Computer computer;

	public BaseballGame() {
		this.computer =  new Computer(BaseballSetGenerator.generate());
	}

	public void start() {

		BaseballResult baseballResult;

		do {
			BaseballSet userInputBaseballSet = BaseballSet.from(BaseballNumberInput.input());
			baseballResult = computer.checkBaseballNumber(userInputBaseballSet);
			Output.baseballResultPrint(baseballResult);
		} while (!baseballResult.isCorrectAnswer());

		Output.gameOverPrint();
	}
}

