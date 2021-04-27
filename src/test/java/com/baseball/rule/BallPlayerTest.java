package com.baseball.rule;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallPlayerTest {

	@ParameterizedTest
	@CsvSource(value = {"f12:false", "f123:false", "1,2,3:false", "1:false", "123:true"}, delimiter = ':')
	@DisplayName("유효성 검증 : 3자리 숫자 테스트")
	public void isProperLengthTest(String inputText, boolean expectedResults) {
		//GIVEN
		BallPlayer BallPlayer = new BallPlayer(inputText);

		//WHEN, THEN
		assertThatThrownBy(() -> {
			Assertions.assertEquals(BallPlayer.isThreeDigits(), expectedResults);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("유효성 체크 :");

	}

}
