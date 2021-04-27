package com.nextstep.baseball.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

	@Test
	@DisplayName("랜덤한 3자리 수 생성 확인")
	void getRandomThreeDigitNumber() {
		String[] numbs = NumberUtils.getRandomThreeDigitNumber();
		boolean isValid = true;
		loop:
		for (int i = 0; i < numbs.length - 1; i++) {
			String temp = numbs[i];
			for (int j = i + 1; j < numbs.length; j++) {
				if (temp.equals(numbs[j])) {
					isValid = false;
					break loop;
				}
			}
		}
		assertThat(isValid).isTrue();
	}

	@Test
	@DisplayName("3자리 수에 대한 스트라이크 판정 확인")
	void checkStrike() {
		String computer = "123";
		String input = "123";
		boolean result = NumberUtils.checkStrike(computer, input);
		assertThat(result).isTrue();
	}

	@Test
	@DisplayName("3자리 수에 대한 3볼 판정 확인")
	void checkBall() {
		String computer = "123";
		String input = "456";
		boolean result = NumberUtils.checkStrike(computer, input);
		assertThat(result).isFalse();
	}

	@Test
	@DisplayName("3자리 수에 대한 스트라이크 및 볼 판정 확인")
	void checkStrikeAndBall() {
		String computer = "123";
		String input = "321";
		boolean result = NumberUtils.checkStrike(computer, input);
		assertThat(result).isFalse();
	}

}