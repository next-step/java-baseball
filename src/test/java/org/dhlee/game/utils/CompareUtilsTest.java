package org.dhlee.game.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompareUtilsTest {

	@Test
	@DisplayName("숫자 비교 테스트")
	public void compareNumbersTest() {
		assertThat(CompareUtils.compareNumbers(3, 3)).isEqualTo(true);
		assertThat(CompareUtils.compareNumbers(3, 4)).isEqualTo(false);
	}
}
