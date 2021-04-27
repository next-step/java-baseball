package com.baseball.woowahan;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTest {
	@Test
	void isGameLength_Three() {
		assertThat(Game.DEFAULT_LENGTH).isEqualTo(3);
	}

}
