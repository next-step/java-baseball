package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameMatchResultTest {

	@Test
	@DisplayName("일치 개수를 1씩 증가할 수 있다.")
	void canIncreaseMatchCount() {
		BaseballGameMatchResult matchResult = new BaseballGameMatchResult();
		for (BaseballNumberMatch numberMatch : BaseballNumberMatch.values()) {
			int matchCount = matchResult.getMatchCount(numberMatch);
			matchResult.increaseMatchCount(numberMatch);
			assertThat(matchResult.getMatchCount(numberMatch)).isSameAs(matchCount + 1);
		}
	}

	@Test
	@DisplayName("야구 숫자의 일치 개수가 3개이면 전체 일치한다.")
	void allMatchIfBaseballNumberMatchIs3() {
		BaseballGameMatchResult matchResult = new BaseballGameMatchResult();
		for (BaseballNumberMatch numberMatch : BaseballNumberMatch.values()) {
			for (int i = 0; i < 3; i++) {
				matchResult.increaseMatchCount(numberMatch);
			}

			assertThat(matchResult.isAllMatch(numberMatch)).isTrue();
		}
	}

}