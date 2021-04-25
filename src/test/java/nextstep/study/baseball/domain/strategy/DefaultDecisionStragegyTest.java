package nextstep.study.baseball.domain.strategy;

import nextstep.study.baseball.domain.Decision;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("판정 전략 테스트")
public class DefaultDecisionStragegyTest {

	@Test
	@DisplayName("기본 판정 전략 테스트")
	void testDefaultDecisionStragegy() {
		DefaultDecisionStrategy strategy = new DefaultDecisionStrategy();
		List<Integer> pitcherNumbers = Arrays.asList(1, 2, 3); //투수의 볼배합

		Decision decision1 = strategy.decide(0, 1, pitcherNumbers);
		assertThat(decision1).isEqualTo(Decision.STRIKE);

		Decision decision2 = strategy.decide(0, 2, pitcherNumbers);
		assertThat(decision2).isEqualTo(Decision.BALL);

		Decision decision3 = strategy.decide(0, 4, pitcherNumbers);
		assertThat(decision3).isEqualTo(Decision.NOTHING);
	}

}
