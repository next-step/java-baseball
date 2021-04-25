package com.baseball.woowahan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * 입력 값 유효성 체크 모듈
 */
class UserInputValidator {
	private final String NUMBER_PATTERN = StringUtils.join("^[1-9]{", GameManager.GAME_LENGTH, "}$");

	public boolean isValid(String input) {
		return isNotNull(input) && isGameLengthAndAllOtherNumbers(input);
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
