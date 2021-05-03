package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumberTest {

	@Test
	@DisplayName("BallNumber 객체 검증")
	void BallNumber객체_숫자_1_9_검증() {
		assertThatThrownBy(() -> {
			new BallNumber(11);
		}).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("볼 숫자는 1부터 9의 값이어야 한다.");

		assertThat(new BallNumber(3).getNo()).isEqualTo(3);
	}
}
