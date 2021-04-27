package game.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HitterTest {

	private Set<Integer> randomNumbers = new HashSet<>();

	@BeforeEach
	void setUp() {
		Random random = new Random();

		while (randomNumbers.size() < 3) {
			randomNumbers.add(random.nextInt(10));
		}
	}

	@Test
	@DisplayName("3 수가 올바르게 만들어지는 여부확인")
	public void makeNumbersTest() {
		assertThat(randomNumbers.size()).isEqualTo(3);
	}

	@Test
	void name() {
	}
}