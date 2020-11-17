package game.baseball.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputNumberTest {

	@Test
	void generateTest() {
		assertThat(InputNumber.generate(456))
			.isNotNull()
			.isInstanceOf(InputNumber.class);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> InputNumber.generate(4567))
			.withMessage("숫자는 3자리의 수 이어야 합니다.");

		assertThatIllegalArgumentException()
			.isThrownBy(() -> InputNumber.generate(454))
			.withMessage("각 자리의 숫자들은 서로 다른 수 이어야 합니다.");

		assertThatIllegalArgumentException()
			.isThrownBy(() -> InputNumber.generate(406))
			.withMessage("각 자리의 숫자들은 1부터 9까지 수 이어야 합니다.");
	}
}
