package io.github.sejoung.study.jdk.string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SplitTest {

	private final String REGEX = ",";

	@DisplayName("정상적으로 split이 동작하는지")
	@Test
	void splitTest() {
		String[] result = "1,2".split(REGEX);

		assertThat(result).contains("1", "2");

	}

	@DisplayName("split대상에 regex값이 없어도 동작하는지")
	@Test
	void splitTest2() {

		String[] result = "1".split(REGEX);

		assertThat(result).containsExactly("1");

	}
}
