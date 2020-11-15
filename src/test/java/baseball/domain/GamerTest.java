package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.ParameterNumberGenerator;

class GamerTest {

	@Test
	@DisplayName("출제자에게 점수를 확인한다.")
	void checkScore() {
		final Questioner questioner = Computer.of(new ParameterNumberGenerator(Arrays.asList(1, 2, 3)));
		final Answerer answerer = Gamer.of(questioner);
		final BaseballResult baseballResult =
			answerer.playGame(BaseballNumbers.of(Arrays.asList(1, 2, 3)));

		assertThat(baseballResult).isInstanceOf(BaseballResult.class);
	}

}