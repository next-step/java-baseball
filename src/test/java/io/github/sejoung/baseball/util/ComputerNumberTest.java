package io.github.sejoung.baseball.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerNumberTest {

	@DisplayName("3자리 생성확인")
	@Test
	void getNumber() {
		String result = ComputerNumber.getNumber(3);
		assertThat(result.length()).isEqualTo(3);
	}

	@DisplayName("생성 숫자 범위 확인")
	@Test
	void numberRangeCheck() {
		String result = ComputerNumber.getNumber(3);

		for (char c : result.toCharArray()) {
			int integer = Character.getNumericValue(c);
			assertThat(integer).isGreaterThanOrEqualTo(1);
			assertThat(integer).isLessThanOrEqualTo(9);
		}

	}
}
