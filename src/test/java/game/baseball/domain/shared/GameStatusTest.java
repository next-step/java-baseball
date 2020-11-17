package game.baseball.domain.shared;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameStatusTest {
	@Test
	void valueOf_ReturnContinueWhenNotWin() {
		assertThat(GameStatus.valueOf(false))
			.isEqualTo(GameStatus.CONTINUE);
	}

	@Test
	void valueOf_ReturnEndWhenWin() {
		assertThat(GameStatus.valueOf(true))
			.isEqualTo(GameStatus.END);
	}

}