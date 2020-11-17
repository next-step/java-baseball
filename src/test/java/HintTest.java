
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
}
