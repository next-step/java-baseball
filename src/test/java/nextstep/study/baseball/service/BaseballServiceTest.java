package nextstep.study.baseball.service;

import nextstep.study.baseball.domain.RefreeDecision;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BaseballServiceTest {

	@DisplayName("판정 결과 출력 테스트")
	@ParameterizedTest
	@CsvSource(value = {"2,1,0", "1,2,0", "3,0,0", "0,0,3"}, delimiter = ',')
	void testShowDecisionMessage(Integer strikeCount, Integer ballCount, Integer nothingCount) {
		RefreeDecision decision = new RefreeDecision(strikeCount, ballCount, nothingCount);
		BaseballService baseballService = new BaseballService();
		baseballService.showDecisionMessage(decision);
	}

}
