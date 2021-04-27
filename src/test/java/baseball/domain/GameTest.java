package baseball.domain;

import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

	@RepeatedTest(100)
	void testRandomIfNumberIsInRange() {
		Game game = new Game();
		game.start();

		int[] numbers = game.getTarget();
		for (int i: numbers) {
			assert(i >= 0 && i <= 9);
		}
	}

	@RepeatedTest(100)
	void testRandomIfNumberDuplicated() {
		Game game = new Game();
		game.start();

		int[] numbers = game.getTarget();
		Set<Integer> set = new HashSet();
		for (int i: numbers) {
			assertThat(set).doesNotContain(i);
		}
	}
}
