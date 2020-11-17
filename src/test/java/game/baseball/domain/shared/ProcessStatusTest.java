package game.baseball.domain.shared;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProcessStatusTest {

	@ParameterizedTest
	@ValueSource(ints = 1)
	void valueOf_ReturnRestartWhenInputOne(int input) {
		assertThat(ProcessStatus.valueOf(input))
			.isEqualTo(ProcessStatus.RESTART);
	}

	@ParameterizedTest
	@ValueSource(ints = 2)
	void valueOf_ReturnExitWhenInputTwo(int input) {
		assertThat(ProcessStatus.valueOf(input))
			.isEqualTo(ProcessStatus.EXIT);
	}

	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6, 7})
	void valueOf_ReturnUnknownWhenOtherNumber(int input) {
		assertThat(ProcessStatus.valueOf(input))
			.isEqualTo(ProcessStatus.UNKNOWN);
	}

}