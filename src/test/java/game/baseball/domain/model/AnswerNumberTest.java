package game.baseball.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerNumberTest {

	@Test
	@DisplayName("generate()는 항상 올바른게 값을 생성한다")
	void generateTest() {
		for (int i = 0; i < 10000; i++) {
			assertThat(AnswerNumber.generate())
				.isNotNull()
				.isInstanceOf(AnswerNumber.class);
		}
	}

	@Test
	@DisplayName("generate()는 항상 동일한 값을 생성하지 않는다")
	void generate_SameResultTest() {
		assertThat(AnswerNumber.generate().getNumber())
			.isNotEqualTo(AnswerNumber.generate().getNumber());
	}
}
