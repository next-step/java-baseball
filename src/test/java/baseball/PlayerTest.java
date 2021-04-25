package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

	@Test
	void equalNumbers() {
		Player player = new Player();

		int[] origin = {1, 2, 3};
		int[] another = {1, 2, 3};

		player.setNumbers(origin);

		assertThat(player.getNumbers()).isEqualTo(another);
	}

	@Test
	void notEqualNumbers() {
		Player player = new Player();

		int[] origin = {1, 2, 3};
		int[] another = {9, 8, 7};

		player.setNumbers(origin);

		assertThat(player.getNumbers()).isNotEqualTo(another);
	}

	@Test
	void threeDigits() {
		Deck deck = new Deck();
		Player opponent = new Player(deck.draw());

		int[] numbers = opponent.getNumbers();

		assertThat(numbers).hasSize(3);
		assertThat(numbers[0]).isBetween(1, 9);
		assertThat(numbers[1]).isBetween(1, 9);
		assertThat(numbers[2]).isBetween(1, 9);
	}
}
