package com.nextstep.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("test")
public class StringTest {


	@Test
	@DisplayName("문자열을 스플릿 한 후 배열에 해당 값들이 잘 들어있는지 테스트")
	void isContainsValues_AfterSplitStringList() {
		String input = "1,2";
		String[] splitInput = input.split(",");
		assertThat(Arrays.asList(splitInput)).contains("1", "2");
	}
}
