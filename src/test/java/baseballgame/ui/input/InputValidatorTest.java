package baseballgame.ui.input;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import basballgame.exception.ValidationException;
import basballgame.ui.input.InputValidator;


public class InputValidatorTest {


	/**
	 @param input: 유효성 검사 대상
	 @param isSuccess: 유효성 체크 통과 여부
	 @param validationException: 유효성 체크 미통과시 Exception
	 **/
	@DisplayName("베이스볼_게임_숫자입력_유효성검사_테스트")
	@ParameterizedTest
	@CsvSource({
		"null,		false,	NumberFormatValidationException",
		",			false,	NumberFormatValidationException",
		"	,		false,	NumberFormatValidationException",
		"String, 	false,	NumberFormatValidationException ",
		"000, 		false, 	NumberRangeValidationException",
		"1000, 		false, 	NumberRangeValidationException",
		"111, 		false, 	MultipleUseNumberValidationException",
		"999, 		false, 	MultipleUseNumberValidationException",
		"122, 		false, 	MultipleUseNumberValidationException",
		"977, 		false, 	MultipleUseNumberValidationException",
		"123, 		true, 	null",
		"456, 		true, 	null",
		"789, 		true, 	null",
	})
	public void InputValidator_validateBaseballNumberInput_테스트(final String input, boolean isSuccess, ValidationException validationException) {

		if (isSuccess) {
			InputValidator.validateBaseballNumberInput(input);
			return;
		}

		assertThatThrownBy(() -> {
			InputValidator.validateBaseballNumberInput(input);
		}).isInstanceOf(validationException.getClass());
	}


	/**
		@param input: 유효성 검사 대상
		@param isSuccess: 유효성 체크 통과 여부
		@param validationException: 유효성 체크 미통과시 Exception
	 **/
	@DisplayName("게임_재시작_입력_유효성_검사_테스트")
	@ParameterizedTest
	@CsvSource({
		"null,		false,	NumberFormatValidationException",
		",			false,	NumberFormatValidationException",
		"	,		false,	NumberFormatValidationException",
		"String, 	false,	NumberFormatValidationException",
		"0,			false, 	GameRestartInputValidationException",
		"3,			false, 	GameRestartInputValidationException",
		"1,			true, null",
		"2,			true, null",

	})
	public void InputValidator_validateGameRestartInputNumber_테스트(final String input, boolean isSuccess, ValidationException validationException) {

		if (isSuccess) {
			InputValidator.validateGameRestartInputNumber(input);
			return;
		}

		assertThatThrownBy(() -> {
			InputValidator.validateGameRestartInputNumber(input);
		}).isInstanceOf(validationException.getClass());
	}

}
