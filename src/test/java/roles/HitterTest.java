package roles;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.RepeatedTest;

import constants.PlayRules;

class HitterTest {

	@RepeatedTest(100)
	void generateNumber() {
		// given
		Hitter hitter = new Hitter();

		// when
		hitter.generateNumber();

		// then
		assertThat(new HashSet<>(hitter.getNumbers()).size()).isEqualTo(PlayRules.BALL_LENGTH.value());
	}
}