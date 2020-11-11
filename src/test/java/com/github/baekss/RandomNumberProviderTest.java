package com.github.baekss;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberProviderTest {

	@Test
	@DisplayName("1부터 9까지 범위에서 임의의 숫자 발생 테스트")
	public void randomNumberTest() {
		int minNumber = 1;
		int maxNumber = 9;
		int randomNumer = RandomNumberProvider.provideRandomNumber(minNumber, maxNumber);
		assertThat(randomNumer).isBetween(minNumber, maxNumber);
	}
}
