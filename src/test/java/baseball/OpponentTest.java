package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OpponentTest {

	@Test
	void threeDigits() {
		Opponent opponent = new Opponent();
		int[] numbers = opponent.getNumbers();
		assertThat(numbers).hasSize(3);
		assertThat(numbers[0]).isBetween(1, 9);
		assertThat(numbers[1]).isBetween(1, 9);
		assertThat(numbers[2]).isBetween(1, 9);
	}

}
