package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

	@Test
	@DisplayName("게임 시작")
	void gamePlay() {

		Game game = new Game();
		assertThat(game.start()).isTrue();
	}

}
