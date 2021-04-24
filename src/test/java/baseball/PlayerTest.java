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
}
