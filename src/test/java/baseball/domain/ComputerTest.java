package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.RandomNumberGenerator;

class ComputerTest {

	@Test
	@DisplayName("3자리 숫자를 생성한다")
	void generate() {
		Questioner questioner = new Computer();
		questioner.generateNumbers(new RandomNumberGenerator());

		assertThat(questioner.numberSize()).isEqualTo(3);
	}
}