package com.baseball.woowahan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.baseball.woowahan.constant.Message;

/**
 * 입력 값 유효성 체크 모듈
 */
class UserInputValidator {
	private final String NUMBER_PATTERN = StringUtils.join("^[1-9]{", Game.GAME_LENGTH, "}$");

	public boolean isValid(String input) {
		return isNotNull(input) && isGameLengthAndAllOtherNumbers(input);
	}

	private boolean isNotNull(String input) {
		if (Objects.nonNull(input)) {
			return true;
		}
		System.out.println(Message.NULL_INPUT.getMessage());
		return false;
	}

	private boolean isGameLengthAndAllOtherNumbers(String input) {
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(input.split("")));
		if (input.matches(NUMBER_PATTERN) && Objects.equals(Game.GAME_LENGTH, set.size())) {
			return true;
		}
		System.out.println(Message.INVALID_INPUT.getMessage());
		return false;
	}
}
