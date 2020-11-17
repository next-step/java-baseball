package baseball.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserInputTest extends UserInput {

	@DisplayName("가상 입력 데이터, 유저 게임 재시작 입력 테스트(한글, 영문, 특수문자는 isNumber() 메서드를 통해 사전에 차단)")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "23525:true", "asdfasdfgxzcvzssdf:false",
		"zxcvlkjewin##@%1235:false", "@#(*&@!(*$&!:false",
		"2:true"}, delimiter = ':')
	void isNumberTest(String inputStringTest, boolean result) {

		assertThat(this.isNumber(inputStringTest)).isEqualTo(result);
	}

	@DisplayName("가상 입력 데이터, 유저 게임 재시작 입력 테스트(한글, 영문, 특수문자는 isNumber() 메서드를 통해 사전에 차단)")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "35:false", "775:false", "4:false", "6:false", "3:false", "2:true"}, delimiter = ':')
	void validRestartNumberTest(int testCaseNumber, boolean result) {
		this.userResultInput = testCaseNumber;

		assertThat(this.validRestartNumber()).isEqualTo(result);
	}

	@DisplayName("가상 입력 데이터, 유저 야구게임 중복없는 3자리 입력 테스트(한글, 영문, 특수문자는 isNumber() 메서드를 사전에 통해 차단)")
	@ParameterizedTest
	@CsvSource(value = {"234:true", "518:true", "549:true", "634:true", "574:true", "5474567:false", "77777:false"},
		delimiter = ':')
	void validBassballNumberTest(int testCaseNumber, boolean result) {
		this.userResultInput = testCaseNumber;

		assertThat(this.validBassballNumber()).isEqualTo(result);
	}
}
