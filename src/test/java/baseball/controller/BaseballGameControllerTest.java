package baseball.controller;

import baseball.domain.Game;
import baseball.view.ConsoleView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class BaseballGameControllerTest {

	private String simulatedInput = "123\n"
			+ "1\n"
			+ "456\n"
			+ "2\n";

	@Test
	void testGame() {
		ByteArrayInputStream iStream = new ByteArrayInputStream(simulatedInput.getBytes());
		System.setIn(iStream);

		Game game = new Game();
		ConsoleView view = new ConsoleView();

		BaseballGameController controller = new BaseballGameController(game, view);
		controller.start();




	}
}
