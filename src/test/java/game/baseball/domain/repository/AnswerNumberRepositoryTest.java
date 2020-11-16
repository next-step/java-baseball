package game.baseball.domain.repository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import game.baseball.domain.model.AnswerNumber;

class AnswerNumberRepositoryTest {
	private final AnswerNumberRepository SUT = new AnswerNumberRepository();

	@Test
	void repositoryTest() {
		SUT.generate();

		assertThat(SUT.getAnswerNumber())
			.isNotNull()
			.isInstanceOf(AnswerNumber.class);
	}

	@Test
	@DisplayName("한번 생성된 AnswerNumber는 다시 생성되기 전까지 같은 숫자를 리턴한다")
	void returnSameNumberUntilRegenerate(){
		SUT.generate();
		int number1 = SUT.getAnswerNumber().getNumber();

		int number2 = SUT.getAnswerNumber().getNumber();

		assertThat(number1)
			.isEqualTo(number2);
	}

	@Test
	@DisplayName("다시 생성하면 다른 숫자를 리턴한다")
	void returnOtherObjectIfRegenerate(){
		SUT.generate();
		int number1 = SUT.getAnswerNumber().getNumber();

		SUT.generate();
		int number2 = SUT.getAnswerNumber().getNumber();

		assertThat(number1)
			.isNotEqualTo(number2);
	}
}
