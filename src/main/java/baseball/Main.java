package baseball;

import baseball.controller.BaseballGameController;
import baseball.domain.Game;
import baseball.view.ConsoleView;

public class Main {


	public static void main(String[] args) {

		Game game = new Game();
		ConsoleView view = new ConsoleView();

		BaseballGameController controller = new BaseballGameController(game, view);
		controller.start();
	}
}
