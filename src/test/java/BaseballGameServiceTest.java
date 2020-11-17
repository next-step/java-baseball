import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameServiceTest {
	BaseballGameService baseballGameService = new BaseballGameService();

	@DisplayName("1-9사이의 숫자를 중복없이 3개 뽑는다")
	@Test
	public void peek3RandomDistinctNumbersTest() {
		int[] peek = baseballGameService.peek3RandomDistinctNumbers();

		// 중복되는 숫자가 없어야 한다.
		assertEquals(3, Arrays.stream(peek)
			.distinct()
			.count());

		// 1 이상 9 이하의 숫자로 구성되어야 한다.
		assertEquals(3, Arrays.stream(peek)
			.filter(num -> num >= 1 && num <= 9)
			.count());
	}

	@DisplayName("3 스트라이크: 3개의 숫자가 위치와 값이 같은 경우")
	@Test
	void getHint_3Strike() {
		int[] answer = {1, 4, 3};
		Hint hint = baseballGameService.getHint(answer, "143");
		assertEquals(3, hint.getStrike());
		assertTrue(hint.is3Strike());
		assertFalse(hint.isNothing());
		assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임종료", hint.getMessage());
	}

	@DisplayName("2 스트라이크: 2개의 숫자가 위치와 값이 같은 경우")
	@Test
	void getHint_2Strike() {
		int[] answer = {1, 4, 3};
		Hint hint = baseballGameService.getHint(answer, "145");
		assertEquals(2, hint.getStrike());
		assertEquals(0, hint.getBall());
		assertFalse(hint.is3Strike());
		assertFalse(hint.isNothing());
		assertEquals("2 스트라이크 ", hint.getMessage());
	}

	@DisplayName("1 스트라이크 2볼: 1개의 숫자가 위치와 값이 같고, 2개의 숫자가 위치는 다르고 값은 같은 경우")
	@Test
	void getHint_1Strike1Ball() {
		int[] answer = {1, 4, 3};
		Hint hint = baseballGameService.getHint(answer, "134");
		assertEquals(1, hint.getStrike());
		assertEquals(2, hint.getBall());
		assertFalse(hint.is3Strike());
		assertFalse(hint.isNothing());
		assertEquals("1 스트라이크 2 볼", hint.getMessage());
	}

	@DisplayName("3 볼: 3개의 숫자가 위치는 다르고 값은 같은 경우")
	@Test
	void getHint_3Ball() {
		int[] answer = {1, 4, 3};
		Hint hint = baseballGameService.getHint(answer, "314");
		assertEquals(3, hint.getBall());
		assertEquals(0, hint.getStrike());
		assertFalse(hint.is3Strike());
		assertFalse(hint.isNothing());
		assertEquals("3 볼", hint.getMessage());
	}

	@DisplayName("낫싱: 0개의 숫자가 위치도 다르고 값도 다른 경우")
	@Test
	void getHint_nothing() {
		int[] answer = {1, 4, 3};
		Hint hint = baseballGameService.getHint(answer, "987");
		assertEquals(0, hint.getStrike());
		assertEquals(0, hint.getBall());
		assertFalse(hint.is3Strike());
		assertTrue(hint.isNothing());
		assertEquals("낫싱", hint.getMessage());
	}


}
