package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.state.DecisionState;
import baseball.state.InningState;
import baseball.state.MenuState;

class GameTest {

	Game game;

	@BeforeEach
	void setUp() {
		game = new Game();
	}

	@Test
	void state() {
		assertThat(game.getState().getClass()).isEqualTo(MenuState.class);
		game.setState(game.getInningState());
		assertThat(game.getState().getClass()).isEqualTo(InningState.class);
	}

	@Test
	void opponent() {
		assertThat(game.getOpponent()).isNull();

		game.setOpponent(new Player(new int[] {1, 2, 3}));

		assertThat(game.getOpponent()).isNotNull();
		assertThat(game.getOpponent().getClass()).isEqualTo(Player.class);
	}

	@Test
	void getMenuState() {
		assertThat(game.getMenuState().getClass()).isEqualTo(MenuState.class);
	}

	@Test
	void getInningState() {
		assertThat(game.getInningState().getClass()).isEqualTo(InningState.class);
	}

	@Test
	void getDecisionState() {
		assertThat(game.getDecisionState().getClass()).isEqualTo(DecisionState.class);
	}

	@Test
	void getPlayer() {
		assertThat(game.getPlayer().getClass()).isEqualTo(Player.class);
	}
}
