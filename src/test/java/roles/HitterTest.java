package roles;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.RepeatedTest;

import constants.PlayRules;

class HitterTest {

	private Hitter hitter = new Hitter();

	@RepeatedTest(100)
	void generateNumber() {
		// given
		List<Integer> integers = new ArrayList<>();

		// when
		integers = hitter.generateNumber();

		// then
		assertThat(new HashSet<>(integers).size()).isEqualTo(PlayRules.BALL_LENGTH.value());
	}
}