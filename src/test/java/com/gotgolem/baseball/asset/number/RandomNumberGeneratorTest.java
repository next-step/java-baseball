package com.gotgolem.baseball.asset.number;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

	private RandomNumberGenerator randomNumberGenerator;

	@BeforeEach
	public void init() {
		randomNumberGenerator = new RandomNumberGenerator();
	}

	@DisplayName("1-9까지의 중복되지 않는 3개의 숫자 생성 테스트")
	@Test
	public void whenGenerateNumbers_thenThreeNumbersFromOneToNineEachDifferent() {
		final int testCount = 10_000;
		for (int i = 0; i < testCount; i++) {
			final int[] numbers = randomNumberGenerator.generateThreeNumbers();
			assertThat(numbers)
					.hasSize(3)
					.containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
					.doesNotHaveDuplicates();
		}
	}

	/**
	 * 아래의 테스트 코드는 들여쓰기가 1단계가 넘고 10라인을 초과하지만,
	 * '테스트 코드 작성 및 검증일 위한 메서드의 분리가 필요한가?' 라는 고민 끝에 원형을 유지하였다.
	 */
	@DisplayName("임의의 숫자 생성 확인 테스트")
	@Test
	public void whenGenerateNumbers_thenRandomNumbers() {
		final int[] referenceNumbers = randomNumberGenerator.generateThreeNumbers();
		final int testCount = 1_000_000;
		final int expectSamePercentageLess = 10;
		int sameCount = 0;

		for (int i = 0; i < testCount; i++) {
			final int[] randomNumbers = randomNumberGenerator.generateThreeNumbers();
			if (Arrays.equals(referenceNumbers, randomNumbers)) {
				sameCount++;
			}
		}

		final double samePercentage = (double)sameCount / testCount * 100;

		assertThat(samePercentage).isLessThan(expectSamePercentageLess);
	}

}
