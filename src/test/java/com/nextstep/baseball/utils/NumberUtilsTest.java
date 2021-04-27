package com.nextstep.baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {

	@Test
	@DisplayName("랜덤한 3자리 수 생성 확인")
	void getRandomThreeDigitNumber() {
		String[] numbs = NumberUtils.getRandomThreeDigitNumber();
		boolean isValid = true;
		loop: for (int i = 0; i < numbs.length - 1; i++) {
			String temp = numbs[i];
			for (int j = i+1; j < numbs.length; j++) {
				if (temp.equals(numbs[j])) {
					isValid = false;
					break loop;
				}
			}
		}
		Assertions.assertThat(isValid).isTrue();
	}
}