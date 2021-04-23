package com.baseball.pre;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringDrillTest {
	@Test
	@DisplayName("1,2를 ,로 split => 1과 2로 분리 확인")
	public void splitTest() {
		String inputText = "1,2";

		String[] testText = inputText.split(",");

		assertThat(testText).contains("1", "2");
	}

	@Test
	@DisplayName("1을 ,로 split => 그래도 1만 나오는지 확인")
	public void splitSingleElementTest() {
		String inputText = "1";

		String[] testText = inputText.split(",");

		assertThat(testText).containsExactly("1");
	}

	@Test
	@DisplayName("(1,2)가 주어졌을때, ()제거하고 1,2 반환 확인")
	public void subStringTest() {
		String inputText = "(1,2)";

		String testText = inputText.substring(
			inputText.indexOf("(")+1, inputText.indexOf(")"));

		Assertions.assertEquals(testText, "1,2");
	}

	@ParameterizedTest
	@CsvSource(value= {"0,a","1,b","2,c"})
	@DisplayName("abc 값이 주어 졌을때 charAt()을 이용하여 특정 위치 확인")
	public void charAtTest(int idx, char expectedChar) {
		String inputText = "abc";

		char testText = inputText.charAt(idx);

		Assertions.assertEquals(testText, expectedChar);
	}

	@Test
	@DisplayName("charAt()을 활용해 outBoundException이 발생하는 부분에 대한 테스트")
	public void exceptionTest() {
		String inputText = "abc";
		int textLength = inputText.length();
		int outedRangeIdx = textLength + 1;

		assertThatThrownBy(() -> {
			char resultTest = inputText.charAt(outedRangeIdx)
		}).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range");
	}
}
