package baseball.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.Game;

class MenuStateTest {

	Game game;
	MenuState menuState;

	@BeforeEach
	void setUp() {
		game = new Game();
		menuState = new MenuState(game);
	}

	@Test
	void start() {
		assertThat(game.getOpponent()).isNull();
		assertThat(game.getState().getClass()).isEqualTo(MenuState.class);
		menuState.start();
		assertThat(game.getOpponent()).isNotNull();
		assertThat(game.getState().getClass()).isEqualTo(InningState.class);
	}

	@Test
	void setOpponent() {
		assertThat(game.getOpponent()).isNull();
		menuState.setOpponent();
		assertThat(game.getOpponent()).isNotNull();
	}

}
