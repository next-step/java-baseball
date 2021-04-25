package baseball.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.Game;

class DecisionStateTest {

	Game game;
	DecisionState decisionState;

	@BeforeEach
	void setUp() {
		game = new Game();
		decisionState = new DecisionState(game);
		game.setState(decisionState);
	}

	@Test
	void isAnswer() {
		assertThat(game.getState().getClass()).isEqualTo(DecisionState.class);
		decisionState.isAnswer(3);
		assertThat(game.getState().getClass()).isEqualTo(MenuState.class);
	}

	@Test
	void isNotAnswer0() {
		assertThat(game.getState().getClass()).isEqualTo(DecisionState.class);
		decisionState.isAnswer(0);
		assertThat(game.getState().getClass()).isEqualTo(InningState.class);
	}

	@Test
	void isNotAnswer1() {
		assertThat(game.getState().getClass()).isEqualTo(DecisionState.class);
		decisionState.isAnswer(1);
		assertThat(game.getState().getClass()).isEqualTo(InningState.class);
	}

	@Test
	void isNotAnswer2() {
		assertThat(game.getState().getClass()).isEqualTo(DecisionState.class);
		decisionState.isAnswer(2);
		assertThat(game.getState().getClass()).isEqualTo(InningState.class);
	}

}
