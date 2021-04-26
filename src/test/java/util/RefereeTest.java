package util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class RefereeTest {
	@Test
	public void isStrikeTest() {
		int strike = Referee.isStrike(0, "123", "137");
		int notStrike = Referee.isStrike(0, "685", "312");
		assertThat(strike).isEqualTo(1);
		assertThat(notStrike).isEqualTo(0);
	}

	@Test
	public void isBallTest() {
		int ball = Referee.isBall(0, "123", "517");
		int notBall = Referee.isBall(0, "685", "312");
		assertThat(ball).isEqualTo(1);
		assertThat(notBall).isEqualTo(0);
	}

	@Test
	public void refereeDecisionTest() {
		int[] case1 = {1, 2};
		int[] case2 = {3, 0};
		int[] case3 = {0, 3};
		int[] case4 = {0, 0};
		assertThat(Referee.refereeDecision(case1)).isNotNull().contains("1 스트라이크").contains("2 볼");
		assertThat(Referee.refereeDecision(case2)).isNotNull().contains("3 스트라이크").doesNotContain("볼");
		assertThat(Referee.refereeDecision(case3)).isNotNull().contains("3 볼").doesNotContain("스트라이크");
		assertThat(Referee.refereeDecision(case4)).isEqualTo("낫싱");
	}
}
