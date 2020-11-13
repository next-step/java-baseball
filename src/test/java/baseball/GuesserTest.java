package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
class GuesserTest {

	@Test
	void guess() {
		assertThat(Guesser.guess(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3))).isEqualTo(new GuessResult(3, 0));
		assertThat(Guesser.guess(Arrays.asList(6, 3, 1), Arrays.asList(6, 1, 3))).isEqualTo(new GuessResult(1, 2));
		assertThat(Guesser.guess(Arrays.asList(7, 2, 9), Arrays.asList(9, 7, 2))).isEqualTo(new GuessResult(0, 3));
		assertThat(Guesser.guess(Arrays.asList(7, 2, 9), Arrays.asList(1, 9, 7))).isEqualTo(new GuessResult(0, 2));
		assertThat(Guesser.guess(Arrays.asList(7, 2, 9), Arrays.asList(5, 6, 7))).isEqualTo(new GuessResult(0, 1));
		assertThat(Guesser.guess(Arrays.asList(7, 2, 9), Arrays.asList(1, 3, 4))).isEqualTo(new GuessResult(0, 0));
	}

}