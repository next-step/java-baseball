package com.precourse.baseball.helper.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {

	@DisplayName("올바른 추측값 Input은 true 리턴한다.")
	@ParameterizedTest
	@ValueSource(strings = {"123"})
	void validGuessInputTest(String input) {
		
		boolean result = Validator.validInput(input); 
		
		assertThat(result).isTrue();
		
	}
	
	@DisplayName("잘못된 추측값 Input은 false 리턴한다. ")
	@ParameterizedTest
	@ValueSource(strings = {"113", "1", ""})
	void invalidGuessInputTest(String input) {
		
		boolean result = Validator.validInput(input); 
		
		assertThat(result).isFalse();
	}
	
	@DisplayName("올바른 게임재개/종료 Input은 true 리턴한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	void validGameContinueInputTest(String input) {
		boolean result = Validator.validGameContinueInput(input); 
		
		assertThat(result).isTrue();
	}
	
	@DisplayName("잘못된 게임재개/종료 Input은 flase를 리턴한다.")
	@ParameterizedTest
	@ValueSource(strings = {"3", "12", ""})
	void invalidGameContinueInputTest(String input) {
		
		boolean result = Validator.validGameContinueInput(input); 
		
		assertThat(result).isFalse();
	}
}
