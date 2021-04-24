package com.baseball.woowahan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

class UserInputValidator {
	private final String NUMBER_PATTERN = StringUtils.join("^[1-9]{", UserInput.GAME_LENGTH, "}$");

	public boolean validate(String input) {
		return isNotNull(input) && isGameLengthAndAllOtherNumbers(input);
	}

	private boolean isNotNull(String input) {
		return Objects.nonNull(input);
	}

	private boolean isGameLengthAndAllOtherNumbers(String input) {
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(input.split("")));
		return input.matches(NUMBER_PATTERN) && Objects.equals(UserInput.GAME_LENGTH, set.size());
	}

}
