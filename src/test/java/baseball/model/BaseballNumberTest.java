/**
* FileName : BaseballNumberTest.java
* Created  : 2021. 4. 26.
* Author   : youngjun.jin
* Summary  : baseball Number 모델을 테스트합니다.
*/
package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

	@ParameterizedTest
	@ValueSource(ints = { 2, 8, 9 })
	@DisplayName("추가한 번호가 정상적으로 추가되었는지 확인")
	void testAddNumber(int expected) {
		BaseballNumber baseballNumber = new BaseballNumber();
		baseballNumber.addNumber(9);
		baseballNumber.addNumber(8);
		baseballNumber.addNumber(2);

		Assertions.assertThat(baseballNumber.getNumbers().contains(expected)).isTrue();
	}

	@Test
	@DisplayName("생성한 baseball number가 null이 아닌지 확인")
	void testBaseballNumberNotNull() {
		BaseballNumber baseballNumber = new BaseballNumber();

		Assertions.assertThat(baseballNumber).isNotNull();
	}

}
