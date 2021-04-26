/**
* FileName : InningResultTest.java
* Created  : 2021. 4. 26.
* Author   : youngjun.jin
* Summary  : inningResult Test
*/
package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InningResultTest {

	private InningResult inningResult;

	private BaseballNumber randomBaseballNumber;

	@BeforeEach
	void setUp() {
		this.inningResult = new InningResult();
		this.randomBaseballNumber = new BaseballNumber();
		this.randomBaseballNumber.addNumber(1);
		this.randomBaseballNumber.addNumber(2);
		this.randomBaseballNumber.addNumber(3);
	}

	@ParameterizedTest
	@ValueSource(strings = { "875", "435", "652" })
	@DisplayName("3 strike 아닐 때 게임 종료 false 반환 확인")
	void testIsEndGameFalse(String userInput) {

		UserBaseballNumber userNumber = new UserBaseballNumber(userInput);

		this.inningResult.judgeInningResult(this.randomBaseballNumber, userNumber);
		Assertions.assertThat(this.inningResult.isEndGame()).isFalse();
	}

	@ParameterizedTest
	@ValueSource(strings = "123")
	@DisplayName("3 strike 일때 게임 종료 true 반환 확인")
	void testIsEndGameTrue(String userInput) {

		UserBaseballNumber userNumber = new UserBaseballNumber(userInput);

		this.inningResult.judgeInningResult(this.randomBaseballNumber, userNumber);
		Assertions.assertThat(this.inningResult.isEndGame()).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = { "123:3 스트라이크", "321:1 스트라이크 2 볼", "456:nothing", "125:2 스트라이크" }, delimiter = ':')
	@DisplayName("randomBaseballNumber, userBaseNumber를 비교하여 inning result 확인")
	void testJudgementInningResult(String userInput, String expected) {

		UserBaseballNumber userNumber = new UserBaseballNumber(userInput);

		this.inningResult.judgeInningResult(this.randomBaseballNumber, userNumber);
		assertEquals(expected, this.inningResult.toString());
	}
}
