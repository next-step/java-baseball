package nextstep.study.baseball.domain.strategy;

import nextstep.study.baseball.domain.DecisionResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("아웃 전략 테스트")
public class DefaultOutStrategyTest {

	@DisplayName("기본 아웃 전략 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,2,0,false", "2,1,0,false", "0,3,0,false", "0,0,3,false", "3,0,0,true"}, delimiter = ',')
	void testDefaultOutStrategy(int strikeCount, int ballCount, int nothingCount, boolean out) {
		DecisionResult decisionResult = new DecisionResult(strikeCount, ballCount, nothingCount);

		DefaultOutStrategy outStrategy = new DefaultOutStrategy();
		boolean isOut = outStrategy.isOut(decisionResult);

		assertThat(isOut).isEqualTo(out);
	}

}
