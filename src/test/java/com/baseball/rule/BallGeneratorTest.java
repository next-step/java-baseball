package com.baseball.rule;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallGeneratorTest {
	@RepeatedTest(100)
	@DisplayName("1~9 정수 생성 테스트")
	public void generateRandomDigitTest() {
		//WHEN
		BallGenerator ballGenerator = new BallGenerator();
		int randomDigit = ballGenerator.generateRandomDigit();

		//THEN
		assertThat(randomDigit).isBetween(1, 9);
	}

	@RepeatedTest(10)
	@DisplayName("3자리 중복되지 않는 정수 생성")
	public void generateNumberTest() {
		//WHEN
		BallGenerator ballGenerator = new BallGenerator();
		List<Integer> generatedNumber = ballGenerator.generateNumber();

		//THEN
		assertThat(generatedNumber.size()).isEqualTo(3);

		for (Integer checkDigit : generatedNumber) {
			assertThat(generatedNumber.contains(checkDigit)).isTrue();
		}
	}

}
