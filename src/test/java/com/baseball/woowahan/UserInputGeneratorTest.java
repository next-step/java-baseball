package com.baseball.woowahan;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserInputGeneratorTest {
	@Test
	void isGameLength_Three() {
		assertThat(UserInput.GAME_LENGTH).isEqualTo(3);
	}

}
