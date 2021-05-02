package numberBaseBallGame.generator;

import numberBaseBallGame.domain.Ball;
import numberBaseBallGame.domain.BaseBallConst;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateClientBallTest {

	@Test
	public void client_볼_생성_green(){
	    // given
		GenerateClientBall generateClientBall = new GenerateClientBall(BaseBallConst.GAMENUMBERS_LENGTH);
	    // when
		List<Ball> balls = generateClientBall.generateBall("123");
		// than
		assertThat(balls)
				.extracting("valueNumber")
				.contains(1, 2, 3);
	}

}