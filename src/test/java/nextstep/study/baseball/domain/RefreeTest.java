package nextstep.study.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.study.baseball.util.BaseballUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RefreeTest {

	@DisplayName("투수와 타자의 숫자값 비교 테스트")
	@ParameterizedTest
	@CsvSource(value = {"123:123"}, delimiter = ':')
	void testMatch(String batterNum, String pitcherNum) {
		System.out.println("batterNum:" + batterNum + ", pitcherNum:" + pitcherNum);

		List<Integer> batterNums = BaseballUtil.strToList(batterNum);
		List<Integer> picherNums = BaseballUtil.strToList(pitcherNum);

		RefreeDecision decision = Referee.makeRefreeDecision(batterNums, picherNums);
		assertThat(decision.getStrikeCount()).isEqualTo(3);
	}

}
