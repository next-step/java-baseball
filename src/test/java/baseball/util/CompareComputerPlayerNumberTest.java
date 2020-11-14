package baseball.util;

import static baseball.util.CompareComputerPlayerNumber.*;
import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompareComputerPlayerNumberTest {

	private Set<Integer> computerNumbers;
	private Set<Integer> playNumbers;

	@BeforeEach
	void setUp() {
		computerNumbers = new LinkedHashSet<>();
		computerNumbers.add(1);
		computerNumbers.add(2);
		computerNumbers.add(3);
	}

	@Test
	void compareStrikeAndBallStrikeOutTest() {
		Set<Integer> playerNumbers = new LinkedHashSet<>();
		playerNumbers.add(1);
		playerNumbers.add(2);
		playerNumbers.add(3);
		assertThat(compareStrikeAndBall(computerNumbers, playerNumbers)).isEqualTo(new Integer[] {3, 0});
	}

	@Test
	void compareStrikeAndBallNothingTest() {
		Set<Integer> playerNumbers = new LinkedHashSet<>();
		playerNumbers.add(4);
		playerNumbers.add(5);
		playerNumbers.add(6);
		assertThat(compareStrikeAndBall(computerNumbers, playerNumbers)).isEqualTo(new Integer[] {0, 0});
	}

	@Test
	void compareStrikeAndBallMixTest() {
		Set<Integer> playerNumbers = new LinkedHashSet<>();
		playerNumbers.add(1);
		playerNumbers.add(3);
		playerNumbers.add(5);
		assertThat(compareStrikeAndBall(computerNumbers, playerNumbers)).isEqualTo(new Integer[] {1, 1});
	}

	@Test
	void getScoreTest() {
		playNumbers = new LinkedHashSet<>();
		playNumbers.add(3);
		playNumbers.add(1);
		playNumbers.add(5);
		assertThat(getScore(0, new Integer[] {0, 0}, 3, playNumbers)).isEqualTo(new Integer[] {1, 0});
		assertThat(getScore(0, new Integer[] {0, 0}, 1, playNumbers)).isEqualTo(new Integer[] {0, 1});
		assertThat(getScore(0, new Integer[] {0, 0}, 8, playNumbers)).isEqualTo(new Integer[] {0, 0});
	}

	@Test
	void calculateScoreBasedStrikeOrBallTest() {
		playNumbers = new LinkedHashSet<>();
		playNumbers.add(3);
		playNumbers.add(1);
		playNumbers.add(5);
		assertThat(calculateScoreBasedStrikeOrBall(0, new Integer[] {0, 0}, 1, playNumbers)).isEqualTo(
			new Integer[] {0, 1});
		assertThat(calculateScoreBasedStrikeOrBall(1, new Integer[] {0, 0}, 1, playNumbers)).isEqualTo(
			new Integer[] {1, 0});
	}

}
