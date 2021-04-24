package com.baseball.woowahan;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputValidatorTest {
	private UserInputValidator userInputValidator = new UserInputValidator();
	private final String NUMBER_PATTERN = StringUtils.join("^[1-9]{", GameManager.GAME_LENGTH, "}$");

	@Test
	@DisplayName("null 입력")
	void isNotNull_False_Test() {
		assertThat(isNotNull(null)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"121", "310", "가12", "1234", "1"})
	@DisplayName("서로다른 3개의 숫자조건 만족실패")
	void isGameLengthAndAllOtherNumbers_False_Test(String input) {
		assertThat(isGameLengthAndAllOtherNumbers(input)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"135", "431", "789"})
	@DisplayName("서로다른 3개의 숫자조건 만족성공")
	void isGameLengthAndAllOtherNumbers_True_Test(String input) {
		assertThat(isGameLengthAndAllOtherNumbers(input)).isTrue();
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"가가1", "133", "노 1", "90213", "012"})
	@DisplayName("null, 서로다른 3개 숫자조건 만족실패")
	void validation_False_Test(String input) {
		assertThat(userInputValidator.isValid(input)).isFalse();
	}

	@Test
	@DisplayName("null, 서로다른 3개 숫자조건 만족성공")
	void validation_True_Test() {
		assertThat(userInputValidator.isValid("597")).isTrue();
	}

	private boolean isNotNull(String input) {
		return Objects.nonNull(input);
	}

	private boolean isGameLengthAndAllOtherNumbers(String input) {
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(input.split("")));
		return input.matches(NUMBER_PATTERN) && Objects.equals(GameManager.GAME_LENGTH, set.size());
	}

}
