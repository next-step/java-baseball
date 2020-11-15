package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.ParameterNumberGenerator;
import baseball.util.RandomNumberGenerator;

class ComputerTest {

	@Test
	@DisplayName("3자리 숫자를 생성한다")
	void generate() {
		Questioner questioner = Computer.of(new RandomNumberGenerator());
		assertThat(questioner.numberSize()).isEqualTo(3);
	}

	@Test
	@DisplayName("게임 결과를 반환한다")
	void checkScore() {
		final List<Integer> numbers = Arrays.asList(1, 2, 3);
		Questioner questioner = Computer.of(new ParameterNumberGenerator(numbers));
		final List<BaseballStatus> baseballStatuses = questioner.checkScore(BaseballNumbers.of(numbers));

		assertThat(baseballStatuses.size()).isEqualTo(3);
	}

}