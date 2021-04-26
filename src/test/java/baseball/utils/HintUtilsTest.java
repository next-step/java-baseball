package baseball.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintUtilsTest {

	@Test
	@DisplayName("테스트 01. 3 스트라이크 성공")
	public void threeStrikeTest01() {
		int[] computerNumber = {1, 2, 3};
		int[] userNumber = {1, 2, 3};

		assertEquals(HintUtils.isThreeStrike(userNumber, computerNumber), true);
	}

	@Test
	@DisplayName("테스트 02. 3 스트라이크 실패")
	public void notThreeStrikeTest02() {
		int[] computerNumber = {1, 2, 3};
		int[] userNumber = {1, 2, 4};

		assertEquals(HintUtils.isThreeStrike(userNumber, computerNumber), false);
	}
}
