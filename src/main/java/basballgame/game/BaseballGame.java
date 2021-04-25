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
			String userInputNum = BaseballNumberInput.input();
			baseballResult = computer.answerCheck(userInputNum);
			Output.baseballResultPrint(baseballResult);
		} while (!baseballResult.isCorrectAnswer());

		Output.gameOverPrint();
	}
}

