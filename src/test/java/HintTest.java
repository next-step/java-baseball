
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {
	@DisplayName("3 스트라이크 : strike 값이 3인 경우 ")
	@Test
	public void is3StrikeTest() {
		Hint threeStrike = new Hint(3, 0);
		assertTrue(threeStrike.is3Strike());
		assertFalse(threeStrike.isNothing());
	}

	@DisplayName("낫싱 : strike 값이 0, ball 값이 0 인 경우 ")
	@Test
	public void isNothingTest() {
		Hint threeStrike = new Hint(0, 0);
		assertFalse(threeStrike.is3Strike());
		assertTrue(threeStrike.isNothing());
	}

	@DisplayName("낫싱")
	@Test
	public void getMessage_Nothing() {
		Hint nothing = new Hint(0, 0);
		assertEquals("낫싱", nothing.getMessage());
	}

	@DisplayName("3개의 숫자를 모두 맞히셨습니다! 게임종료")
	@Test
	public void getMessage_3strike() {
		Hint nothing = new Hint(3, 0);
		assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임종료", nothing.getMessage());
	}

	@DisplayName("1 스트라이크 2 볼")
	@Test
	public void getMessage_1strike2ball() {
		Hint nothing = new Hint(1, 2);
		assertEquals("1 스트라이크 2 볼", nothing.getMessage());
	}

	@DisplayName("3 볼")
	@Test
	public void getMessage_3ball() {
		Hint nothing = new Hint(0, 3);
		assertEquals("3 볼", nothing.getMessage());
	}
}
