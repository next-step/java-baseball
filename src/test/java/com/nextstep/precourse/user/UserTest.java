package com.nextstep.precourse.user;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTest {
	private static User user;

	@BeforeAll
	public static void init() {
		user = new User();
	}

	@Test
	@DisplayName("메뉴 선택 입력값 검증 테스트")
	public void isValidMenuSelectionTest() {
		String[] testInputs = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "가", "나", "다", "A", "b", "c"};

		assertThat(Arrays.asList(testInputs)).as("Validate menu selection test")
			.filteredOn(input -> user.isValidMenuSelection((String)input))
			.containsOnly("1", "2");
	}

	@Test
	@DisplayName("정답 입력값 검증 테스트")
	public void isValidAnswerInputTest() {
		String[] testInputs = {"123", "012", "111", "1234", "ㄱㄴㄷ", "abc", "1ㄱㅁ", "1ab"};

		assertThat(Arrays.asList(testInputs)).as("Validate answer input test")
			.filteredOn(input -> user.isValidAnswerInput((String)input))
			.containsOnly("123");
	}
}
