package com.nextstep.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("test")
public class StringTest {


	@Test
	@DisplayName("요구사항 1. 문자열을 스플릿 한 후 배열에 해당 값들이 잘 들어있는지 테스트")
	void isContainsValues_AfterSplitStringList() {
		String input = "1,2";
		String[] splitInput = input.split(",");
		assertThat(Arrays.asList(splitInput)).contains("1", "2");
	}

	@Test
	@DisplayName("요구사항 1-1. 문자열을 스플릿 한 후 1개 값을 가진 배열에 해당 값들이 잘 들어있는지 테스트")
	void isExactlyContain_AfterSplitStringList(){
		String input = "1";
		String[] splitInput = input.split(",");
		assertThat(Arrays.asList(splitInput)).containsExactly("1");
	}

	@Test
	@DisplayName("요구사항 2. 괄호가 제거되고 문자열이 반환되는지 테스트")
	void isRemovedBracket_fromString(){
		String input = "(1,2)";
		String removedBracketStr = input.substring(1, input.length() - 1);
		String[] splitInput = removedBracketStr.split(",");
		assertThat(Arrays.asList(splitInput)).containsExactly("1","2");
	}
}
