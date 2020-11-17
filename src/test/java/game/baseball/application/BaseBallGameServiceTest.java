package game.baseball.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import game.baseball.domain.model.AnswerNumber;
import game.baseball.domain.model.BaseBallResult;
import game.baseball.domain.repository.AnswerNumberRepository;

class BaseBallGameServiceTest {
	private final BaseBallGameService SUT = new BaseBallGameService();

	@Test
	void startTest() {
		SUT.start();

		assertThat(new AnswerNumberRepository().getAnswerNumber())
			.isNotNull()
			.isInstanceOf(AnswerNumber.class);
	}

	@Test
	void runRound_CorrectInput() {
		assertThat(SUT.runRound(123))
			.isNotNull()
			.isInstanceOf(BaseBallResult.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1234, 223, 306})
	void runRound_IncorrectInput(int number) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> SUT.runRound(number));
	}
}
