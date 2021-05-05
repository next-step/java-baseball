package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallsTest {

	@Test
	@DisplayName("중복된 숫자를 입력했을 경우 Exception 테스트")
	void duplicateTest() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Balls(Arrays.asList(1, 2, 2));
		});
	}

	@Test
	@DisplayName("입력한 숫자가 3자리가 아닐 경우 Exception 테스트")
	void rangeTest() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
			new Balls(Arrays.asList(1, 2));
			new Balls(Arrays.asList(1));
			new Balls(Arrays.asList(1, 2, 3, 4));
		});
	}
}
