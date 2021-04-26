package NumberBaseBallGame.generater;

import NumberBaseBallGame.domain.Ball;
import NumberBaseBallGame.domain.BaseBallConst;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

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
				.contains(1,2,3);
	}

}