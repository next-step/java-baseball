package ui.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.dto.InputDataDto;
import ui.exception.GamePlayException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static ui.type.GamePlayExceptionType.INPUT_DATA_IS_NULL;
import static ui.type.GamePlayExceptionType.INPUT_DATA_DIGIT_NOT_MATCH;
import static ui.type.GamePlayExceptionType.INPUT_DATA_CONTAIN_ZERO;

class InputDataValidatorTest {

	@DisplayName("input value가 null일때 예외발생 테스트")
	@Test
	void preValidateInputDataNullTest(){
		assertThatThrownBy(()->InputDataValidator.preValidateInputData(null))
			.isInstanceOf(GamePlayException.class)
			.hasMessageContaining(INPUT_DATA_IS_NULL.getMessage());
	}

	@DisplayName("input value가 세자리의 숫자가 아닐때 예외발생 테스트")
	@ParameterizedTest
	@ValueSource(strings = {
		"1234", "56798", "01", "1", "987654321"
	})
	void preValidateInputDataNotMatchDigitTest(String value){
		assertThatThrownBy(()->InputDataValidator.preValidateInputData(value))
			.isInstanceOf(GamePlayException.class)
			.hasMessageContaining(INPUT_DATA_DIGIT_NOT_MATCH.getMessage());
	}

	@DisplayName("input value에 0값이 포함되어 있을때 예외발생 테스트")
	@ParameterizedTest
	@ValueSource(ints = {
		101, 100, 110
	})
	void postValidateInputDataContainZeroTest(int value){
		// given
		InputDataDto inputDataDto = makeInputDataDto(value);

		assertThatThrownBy(()->InputDataValidator.postValidateInputData(inputDataDto))
			.isInstanceOf(GamePlayException.class)
			.hasMessageContaining(INPUT_DATA_CONTAIN_ZERO.getMessage());
	}

	InputDataDto makeInputDataDto(final int value){
		return InputDataDto.getInstance(value);
	}
}
