package nextstep.study.baseball.service;

import nextstep.study.baseball.domain.DecisionResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("야구서비스 테스트")
public class BaseballServiceTest {

	@DisplayName("판정 결과 출력 테스트")
	@ParameterizedTest
	@CsvSource(value = {"2,1,0", "1,1,1", "1,2,0", "3,0,0", "0,0,3"}, delimiter = ',')
	void testShowDecisionMessage(Integer strikeCount, Integer ballCount, Integer nothingCount) {
		DecisionResult decision = new DecisionResult(strikeCount, ballCount, nothingCount);
		BaseballService baseballService = new BaseballService();
		baseballService.showDecisionMessage(decision);
	}

}
