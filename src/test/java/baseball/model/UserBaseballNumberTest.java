/**
* FileName : UserBaseballNumberTest.java
* Created  : 2021. 4. 26.
* Author   : youngjun.jin
* Summary  : user baseball number 생성 테스트
*/
package baseball.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.exception.BaseballException;

class UserBaseballNumberTest {

	@ParameterizedTest
	@ValueSource(strings = { "012", "1234", "x12", "xvc", "91x" })
	@DisplayName("숫자 입력시 1~9 범위의 세자리 숫자가 아닌경우 오류발생확인")
	void testUserBaseballNumberError(String userInput) {

		Assertions.assertThatThrownBy(() -> {
			new UserBaseballNumber(userInput);
		}).isInstanceOf(BaseballException.class).hasMessageContaining("1~9 범위의 세자리 숫자를 입력하세요.");
	}

	@ParameterizedTest
	@CsvSource(value = { "123:1", "123:2", "123:3" }, delimiter = ':')
	@DisplayName("123 input으로 받아 userBaseballNumber에 1,2,3이 포함되어있는지 확인")
	void testUserBaseballNumber(String userInput, int value) {
		UserBaseballNumber userBaseballNumber = new UserBaseballNumber(userInput);
		List<Integer> numbers = userBaseballNumber.getNumbers();
		Assertions.assertThat(numbers).contains(value);
	}

}
