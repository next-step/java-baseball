package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import template.BaseballTemplate;

public class BaseballPlayMainTest {

	@Test
	@DisplayName("baseball run test")
	void baseballRun() {
		BaseballTemplate game = new BaseballPlay();
		game.run();
	}
}
