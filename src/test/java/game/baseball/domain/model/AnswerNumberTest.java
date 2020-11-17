package game.baseball.domain.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import game.baseball.domain.shared.NumberUtils;

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

	@ParameterizedTest
	@ValueSource(ints = 234)
	@DisplayName("getIndex()로 가져온 인덱스와 실제 인덱스가 같은지 확인한다.")
	void getIndexTest(int number) {
		List<Integer> numbers = NumberUtils.split(number);
		AnswerNumber answerNumber = AnswerNumberTestHelper.generateAnswerNumber(numbers,
			NumberUtils.createNumberIndexMap(numbers));

		assertThat(answerNumber)
			.isNotNull()
			.isInstanceOf(AnswerNumber.class);

		for (int i = 0; i < BaseBallNumber.NUMBERS_SIZE; i++) {
			assertThat(answerNumber.getIndex(answerNumber.get(i)))
				.isEqualTo(i);
		}
	}
}
