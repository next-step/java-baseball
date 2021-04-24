package com.baseball.woowahan;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {
	private final int MAX_NUMBER = 9;
	private final int MIN_NUMBER = 1;
	private List<Integer> allNumbers;
	private String randomNumbers;

	@BeforeEach
	void init() {
		allNumbers = new ArrayList<>();
		for (int i = MIN_NUMBER; i < MAX_NUMBER; i++) {
			allNumbers.add(i);
		}
		randomNumbers = makeRandomNumbers();
	}

	@Test
	@DisplayName("3자리 랜덤 숫자 확인")
	void isLengthThreeTest() {
		assertThat(randomNumbers.length()).isEqualTo(3);
	}

	@Test
	@DisplayName("랜덤 숫자 중복 확인")
	void isDuplicatedTest() {
		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(randomNumbers.split("")));
		assertThat(set.size()).isEqualTo(makeRandomNumbers().length());
	}

	@Test
	@DisplayName("각 숫자의 1~9 범위 확인")
	void isInRangeAllNumbers() {
		String[] splitRandomNumbers = makeRandomNumbers().split("");
		for (int i = 0; i < splitRandomNumbers.length; i++) {
			assertThat(Integer.parseInt(splitRandomNumbers[i])).isLessThan(10);
			assertThat(Integer.parseInt(splitRandomNumbers[i])).isGreaterThan(0);
		}
	}

	public String makeRandomNumbers() {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		while (stringBuilder.length() < UserInput.GAME_LENGTH) {
			int number = random.nextInt(allNumbers.size());
			stringBuilder.append(allNumbers.get(number));
			allNumbers.remove(number);
		}
		return stringBuilder.toString();
	}
}
