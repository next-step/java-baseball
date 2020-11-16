package edu.nextstep.playground;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlaygroundTest {

	@Test
	@DisplayName("isContinue : 1이 들어오면 true를 리턴해야 함")
	void isContinue_ShouldReturnTrueWhen1Input() {
		// given
		String choice = "1";
		Playground playground = new Playground();

		// when
		boolean isContinue = playground.isContinue(choice);

		// then
		assertTrue(isContinue);
	}

	@Test
	@DisplayName("isContinue : 2가 들어오면 false를 리턴해야 함")
	void isContinue_ShouldReturnFalseWhen1Input() {
		// given
		String choice = "2";
		Playground playground = new Playground();

		// when
		boolean isContinue = playground.isContinue(choice);

		// then
		assertFalse(isContinue);
	}
}