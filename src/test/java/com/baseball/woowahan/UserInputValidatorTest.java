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
import org.junit.jupiter.params.provider.ValueSource;

class UserInputValidatorTest {
	private UserInputValidator userInputValidator = new UserInputValidator();
	private final String NUMBER_PATTERN = StringUtils.join("^[0-9]{", UserInput.GAME_LENGTH, "}$");

	@Test
	@DisplayName("input not null : true")
	void isNotNull_True_Test() {
		assertThat(isNotNull("135")).isTrue();
	}

	@Test
	@DisplayName("input not null : false")
	void isNotNull_False_Test() {
		assertThat(isNotNull(null)).isFalse();
	}

	@Test
	@DisplayName("input match game length and all numbers")
	void isGameLengthAndAllNumbers_True_Test() {
		assertThat(isGameLengthAndAllNumbers("135")).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"12", "1356"})
	@DisplayName("input not match game length")
	void isGameLength_False_Test(String input) {
		assertThat(isGameLengthAndAllNumbers(input)).isFalse();
	}

	@Test
	@DisplayName("input not match all numbers")
	void isAllNumbers_False_Test() {
		assertThat(isGameLengthAndAllNumbers("1가5")).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"121", "335", "666"})
	@DisplayName("input has duplicated numbers")
	void hasNotDuplicatedNumber_False_Test(String input) {
		assertThat(hasNotDuplicatedNumber(input)).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = {"135", "431", "789"})
	@DisplayName("input has unique numbers")
	void hasNotDuplicatedNumber_True_Test(String input) {
		assertThat(hasNotDuplicatedNumber(input)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"가가1", "133", "노 1", "90213", "012"})
	@DisplayName("input has unique numbers")
	void validation_False_Test(String input) {
		assertThat(userInputValidator.validate(input)).isFalse();
	}

	@Test
	@DisplayName("input has unique numbers")
	void validation_True_Test() {
		assertThat(userInputValidator.validate("597")).isTrue();
	}

	private boolean isNotNull(String input) {
		return Objects.nonNull(input);
	}

	private boolean isGameLengthAndAllNumbers(String input) {
		return input.matches(NUMBER_PATTERN);
	}

	private boolean hasNotDuplicatedNumber(String input) {
		Set set = new HashSet();
		set.addAll(Arrays.asList(input.split("")));
		return Objects.equals(UserInput.GAME_LENGTH, set.size());
	}
}
