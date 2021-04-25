package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

	private Ball ball = new Ball();
	private List<Integer> answerList;

	@BeforeEach
	void setUpRandomAnswerBall() {
		ball.makeRandomlyThreeDigitAnswer();
		answerList = ball.getAnswerArray();
	}

	@Test
	@DisplayName("임의의 숫자가 3개 선택되었는지 테스트.")
	void isThreeDigitsGeneratedRandomBalls() {
		assertThat(answerList.size()).isEqualTo(3);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 10})
	@DisplayName("생성된 정답의 각 자리 숫자가 1부터 9까지를 만족하는지 테스트.")
	void isContainsZeroOrTen(int paramNumber) {
		assertThat(answerList.contains(paramNumber)).isFalse();
	}
}
