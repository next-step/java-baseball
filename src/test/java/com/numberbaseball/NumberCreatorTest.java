package com.numberbaseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberCreatorTest {
	public static final int ENOUGH_TEST_COUNT = 100_000;
	private NumberCreator numberCreator;

	@BeforeEach
	void create() {
		numberCreator = new NumberCreator();
	}

	@Test
	@DisplayName("생성된 숫자가 세 자리수 인지 테스트")
	void 세_자리수_숫자_생성_테스트() {

		for (int i = 0; i < ENOUGH_TEST_COUNT; i++) {
			int number = numberCreator.createEachNumberIsUniqueThreeDigitNumber();
			assertThat(number).isBetween(1, 999);
		}
	}

	@Test
	void 각_자리수_중복되지_않는지_테스트() {
		for (int i = 0; i < ENOUGH_TEST_COUNT; i++) {
			int number = numberCreator.createEachNumberIsUniqueThreeDigitNumber();
			int eachDigitNumberSize = eachDigitNumberToSet(number).size();
			assertThat(eachDigitNumberSize).isEqualTo(3);
		}
	}

	private Set<Integer> eachDigitNumberToSet(int number) {
		String numberStr = String.valueOf(number);
		Set<Integer> numberSets = new HashSet<>();

		for (char c : numberStr.toCharArray()) {
			numberSets.add((int)c);
		}

		return numberSets;
	}
}