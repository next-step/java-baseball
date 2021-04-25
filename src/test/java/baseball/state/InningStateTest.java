package baseball.state;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.Game;

class InningStateTest {

	Game game;
	InningState inningState;

	@BeforeEach
	void setUp() {
		game = new Game();
		inningState = new InningState(game);
		game.setState(inningState);
	}

	@Test
	void guess() {
		assertThat(game.getState().getClass()).isEqualTo(InningState.class);

		int[] origin = {1, 2, 3};
		int[] another = {-1, -1, -1};
		inningState.guess("123");

		assertThat(game.getPlayer().getNumbers()).isEqualTo(origin);
		assertThat(game.getPlayer().getNumbers()).isNotEqualTo(another);
		assertThat(game.getState().getClass()).isEqualTo(DecisionState.class);
	}

	@Test
	void isThreeDigits() {
		assertThat(inningState.isThreeDigits("100")).isTrue();
		assertThat(inningState.isThreeDigits("999")).isTrue();

		assertThat(inningState.isThreeDigits("000")).isFalse();
		assertThat(inningState.isThreeDigits("099")).isFalse();
		assertThat(inningState.isThreeDigits("1000")).isFalse();

		assertThat(inningState.isThreeDigits("")).isFalse();
		assertThat(inningState.isThreeDigits("text")).isFalse();
	}
}
