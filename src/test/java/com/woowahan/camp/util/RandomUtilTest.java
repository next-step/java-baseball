package com.woowahan.camp.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomUtilTest {

	@DisplayName("randomNum메서드는 숫자를 입력받아 0부터 입력받은 숫자보다 1 작은 수까지 랜덤하게 숫자가 출력됨을 확인한다.")
	@RepeatedTest(100)
	void randomNumTest() {
		//Given
		int[] arrValue = new int[] {
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};

		for (int value : arrValue) {
			//When
			int result = RandomUtil.randomNum(value);

			//Then
			assertThat(result).isBetween(0, value - 1);
		}
	}
}