package game.baseball.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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

	@ParameterizedTest
	@ValueSource(ints = 123)
	@DisplayName("정상적인 값을 입력받아 runRound()를 실행하면 BaseBallResult를 반환한다")
	void runRound_CorrectInput(int input) {
		assertThat(SUT.runRound(input))
			.isNotNull()
			.isInstanceOf(BaseBallResult.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1234, 223, 306})
	@DisplayName("비정상적인 값을 입력받아 runRound()를 실행하면 IllegalArgumentException이 발생한다")
	void runRound_IncorrectInput(int input) {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> SUT.runRound(input));
	}
}
