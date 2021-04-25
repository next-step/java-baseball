package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallGeneratorTest {

	private List<Integer> balls;

	@BeforeEach
	void initBallNumbers() {
		balls = BallGenerator.generateBalls();
	}

	@DisplayName("1부터 9사이의 무작위 볼 3개 생성")
	@Test
	void generate_3_numbers() {
		assertThat(balls.size()).isEqualTo(3);

		for (Integer ball : balls) {
			assertThat(ball).isBetween(1, 9);
		}
	}

	@DisplayName("3개의 무작위 볼이 중복 되지 않았는지 확인")
	@Test
	void not_duplicated_numbers() {
		assertThat(BallUtil.isNotDuplicateNumber(balls)).isTrue();
	}
}
