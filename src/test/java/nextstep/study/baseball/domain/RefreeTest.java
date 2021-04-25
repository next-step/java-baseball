package nextstep.study.baseball.domain;

import nextstep.study.baseball.util.BaseballUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("심판 테스트")
public class RefreeTest {

	@DisplayName("투수와 타자의 숫자값 비교 테스트")
	@ParameterizedTest
	@CsvSource(value = {"123:123"}, delimiter = ':')
	void testMatch(String batterNum, String pitcherNum) {

		List<Integer> batterNums = BaseballUtil.strToList(batterNum);
		List<Integer> picherNums = BaseballUtil.strToList(pitcherNum);

		Referee referee = new Referee();
		DecisionResult decision = referee.makeDecisionResult(batterNums, picherNums);
		System.out.println(decision);

		assertThat(decision.getStrikeCount()).isEqualTo(3);
	}

}
