package com.baseball.rule;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class PitcherTest {
	@RepeatedTest(100)
	@DisplayName("1~9 정수 생성 테스트")
	public void generateRandomDigitTest() {
		//WHEN
		Pitcher pitcher = new Pitcher();
		int randomDigit = pitcher.generateRandomDigit();

		//THEN
		assertThat(randomDigit).isBetween(1, 9);
	}

	@RepeatedTest(10)
	@DisplayName("3자리 중복되지 않는 정수 생성")
	public void generateNumberTest() {
		//WHEN
		Pitcher pitcher = new Pitcher();
		List<Integer> generatedNumber = pitcher.generateNumber();

		//THEN
		assertThat(generatedNumber.size()).isEqualTo(3);

		for (Integer checkDigit : generatedNumber) {
			assertThat(generatedNumber.contains(checkDigit)).isTrue();
		}
	}

}
