package model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

	private Game game;

	@BeforeEach
	void beforeEach() {
		game = new Game();
	}

	@DisplayName("같은 숫자,같은 위치인 숫자가 3개 있으면 3스트라이크이다.")
	@Test
	void threeNumbersMatchAndOrder() throws IOException {
		game.setCom(new int[] {1, 3, 7});
		game.setUser(new int[] {1, 3, 7});

		game.computeStrikeAndBall();
		assertEquals(game.getStrike(), 3);
		assertEquals(game.getBall(), 0);
	}

	@DisplayName("같은 숫자, 같은 위치인 숫자가 2개있으면 2스트라이크이다.")
	@Test
	void twoNumbersMatchAndOrderTest() {
		game.setCom(new int[] {4, 5, 6});
		game.setUser(new int[] {4, 5, 3});

		game.computeStrikeAndBall();
		assertEquals(game.getStrike(), 2);
		assertEquals(game.getBall(), 0);
	}

	@DisplayName("같은 숫자가 2개 있지만 하나만 위치가 맞으면 1스트라이크, 1볼이다.")
	@Test
	void twoNumberMatchAndOneMatchOrderTest() {
		game.setCom(new int[] {3, 5, 4});
		game.setUser(new int[] {4, 5, 1});

		game.computeStrikeAndBall();
		assertEquals(game.getStrike(), 1);
		assertEquals(game.getBall(), 1);
	}

	@DisplayName("같은 숫자 같은 위치인 숫자가 하나있으면, 1스트라이크이다.")
	@Test
	void oneNumberMatchAndOrderTest() {
		game.setCom(new int[] {4, 7, 8});
		game.setUser(new int[] {4, 3, 6});

		game.computeStrikeAndBall();
		assertEquals(game.getStrike(), 1);
		assertEquals(game.getBall(), 0);
	}

	@DisplayName("숫자가 1개 같고 순서가 다르면, 1볼이다.")
	@Test
	void oneNumberMatchButDifferentOrderTest() {
		game.setCom(new int[] {9, 1, 2});
		game.setUser(new int[] {1, 4, 7});

		game.computeStrikeAndBall();
		assertEquals(game.getStrike(), 0);
		assertEquals(game.getBall(), 1);
	}

	@DisplayName("숫자가 2개정도 같고 순서가 다르면, 3볼이다.")
	@Test
	void twoNumbersMatchButDifferentOrderTest() {
		game.setCom(new int[] {3, 1, 6});
		game.setUser(new int[] {1, 3, 5});

		game.computeStrikeAndBall();
		assertEquals(game.getStrike(), 0);
		assertEquals(game.getBall(), 2);
	}

	@DisplayName("숫자가 모두 같지만 순서가 다르면, 3볼이다.")
	@Test
	void numbersAllMatchButDifferentOrderTest() {
		game.setCom(new int[] {1, 6, 5});
		game.setUser(new int[] {6, 5, 1});

		game.computeStrikeAndBall();
		assertEquals(game.getStrike(), 0);
		assertEquals(game.getBall(), 3);
	}

	@DisplayName("같은 숫자가 하나도 없으면, 낫싱이다.")
	@Test
	void withoutAnySameNumberTest() {
		game.setCom(new int[] {1, 5, 6});
		game.setUser(new int[] {2, 4, 7});

		game.computeStrikeAndBall();
		assertEquals(game.getStrike(), 0);
		assertEquals(game.getBall(), 0);
	}
}