package baseball.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Game;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DecisionStateTest {

	Game game;
	DecisionState decisionState;

	@BeforeEach
	void setUp() {
		game = new Game();
		decisionState = new DecisionState(game);
		game.onDecisionState();
	}

	@DisplayName("정답이면 메뉴로 돌아간다.")
	@Test
	void isAnswer() {
		decisionState.isAnswer(3);
		assertThat(game.currentState().getClass()).isEqualTo(MenuState.class);
	}

	@DisplayName("오답이면 이닝으로 돌아간다.")
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2})
	void isNotAnswer(int strikes) {
		decisionState.isAnswer(strikes);
		assertThat(game.currentState().getClass()).isEqualTo(InningState.class);
	}
}
