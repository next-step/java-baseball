package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ui.dto.InputDataDto;

import static org.assertj.core.api.Assertions.assertThat;

class InputDataDtoTest {


	@DisplayName("정상적인 input value, 성공 케이스")
	@ParameterizedTest
	@ValueSource(ints = {
		123, 456, 789
	})
	void getInstanceTest(int inputData){
		// given
		int hundred = inputData/100;
		int ten = (inputData%100)/10;
		int one = (inputData%100)%10;

		// when
		InputDataDto inputDataDto = InputDataDto.getInstance(inputData);

		// then
		assertThat(inputDataDto).isNotNull();
		assertThat(inputDataDto.getNumberWithDigit(InputDataDto.Digit.HUNDRED)).isEqualTo(hundred);
		assertThat(inputDataDto.getNumberWithDigit(InputDataDto.Digit.TEN)).isEqualTo(ten);
		assertThat(inputDataDto.getNumberWithDigit(InputDataDto.Digit.ONE)).isEqualTo(one);
		assertThat(inputDataDto.containZero()).isFalse();
	}

	@DisplayName("0을 포함한 수를 보유하면 containZero method true")
	@ParameterizedTest
	@ValueSource(ints = {
		012, 102, 120
	})
	void containZeroTest(int inputData){
		// given

		// when
		InputDataDto inputDataDto = InputDataDto.getInstance(inputData);

		// then
		assertThat(inputDataDto).isNotNull();
		assertThat(inputDataDto.containZero()).isTrue();
	}
}
