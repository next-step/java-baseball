package com.baseball.woowahan;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameManagerTest {
	@Test
	void isGameLength_Three() {
		assertThat(GameManager.GAME_LENGTH).isEqualTo(3);
	}

}
