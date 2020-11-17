package game.baseball.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.baseball.domain.shared.Message;

class InputNumberTest {

	@Test
	void generateTest() {
		assertThat(InputNumber.generate(456))
			.isNotNull()
			.isInstanceOf(InputNumber.class);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> InputNumber.generate(4567))
			.withMessage(Message.REQUIRE_THREE_DIGIT);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> InputNumber.generate(454))
			.withMessage(Message.REQUIRE_DIFFERENT_NUMBER);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> InputNumber.generate(406))
			.withMessage(Message.REQUIRE_ONE_TO_NINE);
	}
}
