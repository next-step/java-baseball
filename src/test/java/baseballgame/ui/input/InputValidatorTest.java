package baseballgame.ui.input;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import basballgame.exception.ExceptionMessages;
import basballgame.exception.GameRestartInputValidationException;
import basballgame.exception.MultipleUseNumberValidationException;
import basballgame.exception.NumberFormatValidationException;
import basballgame.exception.NumberRangeValidationException;
import basballgame.exception.ValidationException;
import basballgame.ui.input.InputValidator;


public class InputValidatorTest {


	/**
	 @param input: 유효성 검사 대상
	 **/
	@DisplayName("베이스볼_게임_숫자입력_숫자형식_예외발생_테스트")
	@ParameterizedTest
	@CsvSource({
		"null,",
		"String,",
		",",
		"   ,",
	})
	public void validateBaseballNumberInput_InvalidInput_NumberFormatValidationException(final String input) {

		assertThatThrownBy(() -> {
			InputValidator.validateBaseballNumberInput(input);
		}).isInstanceOf(NumberFormatValidationException.class)
			.hasMessageContaining(ExceptionMessages.INVALID_NUMBER_FORMAT);
	}

	/**
	 @param input: 유효성 검사 대상
	 **/
	@DisplayName("베이스볼_게임_숫자입력_숫자범위_예외발생_테스트")
	@ParameterizedTest
	@CsvSource({
		"000,",
		"1000,",
	})
	public void validateBaseballNumberInput_InvalidInput_NumberRangeValidationException(final String input) {

		assertThatThrownBy(() -> {
			InputValidator.validateBaseballNumberInput(input);
		}).isInstanceOf(NumberRangeValidationException.class)
			.hasMessageContaining(ExceptionMessages.INVALID_NUMBER_RANGE);
	}

	/**
	 @param input: 유효성 검사 대상
	 **/
	@DisplayName("베이스볼_게임_숫자입력_중복숫자입력_예외발생_테스트")
	@ParameterizedTest
	@CsvSource({
		"111,",
		"999,",
		"122,",
		"977,",
	})
	public void validateBaseballNumberInput_InvalidInput_MultipleUseNumberValidationException(final String input) {

		assertThatThrownBy(() -> {
			InputValidator.validateBaseballNumberInput(input);
		}).isInstanceOf(MultipleUseNumberValidationException.class)
			.hasMessageContaining(ExceptionMessages.INVALID_MULTIPLE_USE_NUMBER);
	}

	/**
	 @param input: 유효성 검사 대상
	 **/
	@DisplayName("베이스볼_게임_숫자입력_성공_테스트")
	@ParameterizedTest
	@CsvSource({
		"123,",
		"234,",
		"345,",
		"456,",
		"678,",
		"789,",
	})
	public void validateBaseballNumberInput_InvalidInput_Success(final String input) {
		InputValidator.validateBaseballNumberInput(input);
	}

	/**
		@param input: 유효성 검사 대상
	 **/
	@DisplayName("게임_재시작_입력_숫자형식_예외발생_테스트")
	@ParameterizedTest
	@CsvSource({
		"null,",
		",",
		"	,",
		"String,",
	})
	public void validateGameRestartInputNumber_InvalidInput_NumberFormatValidationException(final String input) {

		assertThatThrownBy(() -> {
			InputValidator.validateGameRestartInputNumber(input);
		}).isInstanceOf(NumberFormatValidationException.class)
			.hasMessageContaining(ExceptionMessages.INVALID_NUMBER_FORMAT);
	}


	/**
	 @param input: 유효성 검사 대상
	 **/
	@DisplayName("게임_재시작_입력_숫자입력_예외발생_테스트")
	@ParameterizedTest
	@CsvSource({
		"0,",
		"3,",
	})
	public void validateGameRestartInputNumber_InvalidInput_GameRestartInputValidationException(final String input) {

		assertThatThrownBy(() -> {
			InputValidator.validateGameRestartInputNumber(input);
		}).isInstanceOf(GameRestartInputValidationException.class)
			.hasMessageContaining(ExceptionMessages.INVALID_GAME_RESTART_INPUT_NUMBER);
	}

	/**
	 @param input: 유효성 검사 대상
	 **/
	@DisplayName("게임_재시작_입력_성_테스트")
	@ParameterizedTest
	@CsvSource({
		"1,",
		"2,",
	})
	public void validateGameRestartInputNumber_InvalidInput_Success(final String input) {
		InputValidator.validateGameRestartInputNumber(input);
	}

}
