package game.baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PitcherTest {

	private Pitcher pitcher;

	@BeforeEach
	void setup() {
		pitcher = new Pitcher();
	}

	@ParameterizedTest
	@DisplayName("pitch 에 수가 제대로 들어가면 분할이 정확히 되는가.")
	@ValueSource(strings = {"123"})
	void isRight_ShouldSplit3DigitsFromString(String pitchNumbers) {
		pitcher.setPitch(pitchNumbers);
		pitcher.setPiches();

		assertThat(pitcher.getPitches()[0]).isEqualTo(1);
		assertThat(pitcher.getPitches()[1]).isEqualTo(2);
		assertThat(pitcher.getPitches()[2]).isEqualTo(3);
	}
}