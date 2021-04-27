package baseball.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

	@DisplayName("게임을 시작하면 상대방을 생성하고 이닝으로 들어간다.")
	@Test
	void start() {
		assertThat(game.getOpponent()).isNull();
		assertThat(game.currentState().getClass()).isEqualTo(MenuState.class);
		menuState.start();
		assertThat(game.getOpponent()).isNotNull();
		assertThat(game.currentState().getClass()).isEqualTo(InningState.class);
	}

}
