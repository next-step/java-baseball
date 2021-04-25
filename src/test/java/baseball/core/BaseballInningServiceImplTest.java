/**
* FileName : BaseballInningServiceImplTest.java
* Created  : 2021. 4. 25.
* Author   : youngjun.jin
* Summary  : baseball inning service 구현체 테스트
*/
package baseball.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.BaseballNumber;
import baseball.model.InningResult;

class BaseballInningServiceImplTest {

	private BaseballInningService target;

	@BeforeEach
	void setup() {
		BaseballNumber targetNumber = new BaseballNumber(9, 1, 2);
		this.target = new BaseballInningServiceImpl(targetNumber);

	}

	@ParameterizedTest
	@CsvSource(value = { "912:InningResult [strike=3, ball=0]", "129:InningResult [strike=0, ball=3]",
			"345:InningResult [strike=0, ball=0]", "312:InningResult [strike=2, ball=0]" }, delimiter = ':')
	@DisplayName("입력결과에 대해 스트라이크, 볼 카운트가 맞는지 확인합니다.")
	void testJudgeInningThreeStrike(String userInput, String expected) {

		InningResult judgeInning = this.target.judgeInning(userInput);
		assertEquals(expected, judgeInning.toString());
	}

}
