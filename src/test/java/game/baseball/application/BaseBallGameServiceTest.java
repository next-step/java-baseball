package game.baseball.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.baseball.domain.model.AnswerNumber;
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
}
