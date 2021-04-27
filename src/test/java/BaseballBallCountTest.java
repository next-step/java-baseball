import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballBallCountTest {
	BaseballBallCount ballCount;

	@BeforeEach
	void init() {
		ballCount = new BaseballBallCount();
	}

	@Test
	void setCallSign0to0Test() {
		// given
		String anwer = "384";
		String attackKeyword = "159";
		// when
		ballCount.setCallSign(anwer, attackKeyword);
		//then
		assertThat(ballCount.getCallSign()).isEqualTo("낫싱");
	}

	@Test
	void setCallSign1to0Test() {
		// given
		String anwer = "384";
		String attackKeyword = "189";
		// when
		ballCount.setCallSign(anwer, attackKeyword);
		//then
		assertThat(ballCount.getCallSign()).isEqualTo("1스트라이크");
	}

	@Test
	void setCallSign0to2Test() {
		// given
		String anwer = "384";
		String attackKeyword = "543";
		// when
		ballCount.setCallSign(anwer, attackKeyword);
		//then
		assertThat(ballCount.getCallSign()).isEqualTo("2볼");
	}

	@Test
	void setCallSign1to2Test() {
		// given
		String anwer = "384";
		String attackKeyword = "483";
		// when
		ballCount.setCallSign(anwer, attackKeyword);
		//then
		assertThat(ballCount.getCallSign()).isEqualTo("1스트라이크 2볼");
	}
}
