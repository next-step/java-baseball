package baseball;

import baseball.controller.BaseballController;
import baseball.view.console.BaseballInputConsole;
import baseball.view.console.BaseballOutputConsole;

public class BaseballApplication {
	public static void main(String[] args) {
		BaseballController baseballController = BaseballController.of(
				new BaseballInputConsole(),
				new BaseballOutputConsole()
		);
		baseballController.run();
	}
}
