package org.dhlee.game.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballPlayerTest {
	private static final BaseballPlayer baseballPlayer = new BaseballPlayer("computer");

	@BeforeAll
	static void setup() {
		Integer[] numbers = {3, 5, 6};
		baseballPlayer.setNumbers(Arrays.asList(numbers));
	}

	@Test
	@DisplayName("스트라이크 카운트 테스트")
	public void getStrikeCountTest() {
		Integer[] numbers = {2, 7, 9};
		assertThat(baseballPlayer.getStrikeCount(Arrays.asList(numbers))).isEqualTo(0);
		Integer[] numbers2 = {3, 1, 2};
		assertThat(baseballPlayer.getStrikeCount(Arrays.asList(numbers2))).isEqualTo(1);
		Integer[] numbers3 = {3, 5, 2};
		assertThat(baseballPlayer.getStrikeCount(Arrays.asList(numbers3))).isEqualTo(2);
		Integer[] numbers4 = {3, 5, 6};
		assertThat(baseballPlayer.getStrikeCount(Arrays.asList(numbers4))).isEqualTo(3);
	}

	@Test
	@DisplayName("볼 카운트 테스트")
	public void getBallCountTest() {
		Integer[] numbers = {2, 7, 9};
		assertThat(baseballPlayer.getBallCount(Arrays.asList(numbers))).isEqualTo(0);
		Integer[] numbers2 = {7, 1, 3};
		assertThat(baseballPlayer.getBallCount(Arrays.asList(numbers2))).isEqualTo(1);
		Integer[] numbers3 = {5, 6, 7};
		assertThat(baseballPlayer.getBallCount(Arrays.asList(numbers3))).isEqualTo(2);
		Integer[] numbers4 = {5, 6, 3};
		assertThat(baseballPlayer.getBallCount(Arrays.asList(numbers4))).isEqualTo(3);
	}
}
