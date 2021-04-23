package com.baseball.pre;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringDrillTest {
	@Test
	public void splitTest() {
		String inputText = "1,2";

		assertThat(inputText.split(",")).contains("1", "2");
	}

	@Test
	public void splitSingleElementTest() {
		String inputText = "1";

		assertThat(inputText.split(",")).containsExactly("1");
	}

}
