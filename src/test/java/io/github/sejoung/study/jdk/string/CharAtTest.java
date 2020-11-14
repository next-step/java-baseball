package io.github.sejoung.study.jdk.string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CharAtTest {

	@DisplayName("특정위치의 문자값을 정상적으로 가지고 오는지 테스트")
	@Test
	void charAtTest() {

		String arg = "abc";
		char result = arg.charAt(0);
		assertThat(result).isEqualTo('a');

	}

	@DisplayName("StringIndexOutOfBoundsException 에러 확인")
	@Test
	void error() {

		int index = 10;
		assertThatThrownBy(() -> {
			"abc".charAt(index);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessage(String.format("String index out of range: %d", index));

	}
}
