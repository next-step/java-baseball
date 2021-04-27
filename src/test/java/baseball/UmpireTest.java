package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UmpireTest {
	private Umpire umpire;

	@BeforeEach
	void setUp() {
		this.umpire = new Umpire();
	}

	@AfterEach
	void tearDown() {
		this.umpire = null;
	}

	@Test
	void judge() {
		String attackNumbers = "713";

		Score score0 = umpire.judge(attackNumbers, "999");
		assertThat(score0.getStrikeCount()).isEqualTo(0);
		assertThat(score0.getBallCount()).isEqualTo(0);

		Score score1 = umpire.judge(attackNumbers, "123");
		assertThat(score1.getStrikeCount()).isEqualTo(1);
		assertThat(score1.getBallCount()).isEqualTo(1);

		Score score2 = umpire.judge(attackNumbers, "145");
		assertThat(score2.getStrikeCount()).isEqualTo(0);
		assertThat(score2.getBallCount()).isEqualTo(1);

		Score score3 = umpire.judge(attackNumbers, "671");
		assertThat(score3.getStrikeCount()).isEqualTo(0);
		assertThat(score3.getBallCount()).isEqualTo(2);

		Score score4 = umpire.judge(attackNumbers, "216");
		assertThat(score4.getStrikeCount()).isEqualTo(1);
		assertThat(score4.getBallCount()).isEqualTo(0);

		Score score5 = umpire.judge(attackNumbers, "713");
		assertThat(score5.getStrikeCount()).isEqualTo(3);
		assertThat(score5.getBallCount()).isEqualTo(0);
	}
}
