package test.baseball;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.BaseballGame;

public class BasbeallGameTest {
	private static BaseballGame testGame = new BaseballGame();
	private static int[] inputNumArr = testGame.getInputNum();
	private static int[] randomNumArr = testGame.getRandomNum();

	/**
	 * 랜덤 값 유효성 검사
	 */
	@Test
	public void testRandomValid() {
		testArraySizeCheck(randomNumArr.length);
		for (int randomNum : randomNumArr) {
			testValidNumberCheck(randomNum);
		}
	}

	/**
	 * 인풋 값 유효성 검사
	 */
	@Test
	public void testInputNumValid() {
		testArraySizeCheck(inputNumArr.length);
		for (int inputNum : inputNumArr) {
			testValidNumberCheck(inputNum);
		}
	}

	/**
	 * 야구게임 계산 카운트 확인
	 */
	@Test
	public void testBaseballCount() {
		// value,index가 모두 동일시 strike ++
		testGame.checkBaseballCount(3, 3, 3, 3);
		// value가 같고 index가 다를 시 ball ++
		testGame.checkBaseballCount(3, 3, 2, 3);

		assertEquals(testGame.getBall(), 1);
		assertEquals(testGame.getStrike(), 1);
	}

	/**
	 * 야구게임 카운트 리셋 확인
	 */
	@Test
	public void testBaseballReset() {
		testGame.resetBaseballCount();

		assertEquals(testGame.getBall(), 0);
		assertEquals(testGame.getStrike(), 0);
	}

	/**
	 * 숫자 비교 확인
	 */
	@Test
	public void testEqualToNum() {
		// 비교값이 일치할때 1, 다를때 0 return
		int testEqual = testGame.equalToNum(1, 1);
		int testNotEqual = testGame.equalToNum(1, 2);

		assertEquals(testEqual, 1);
		assertEquals(testNotEqual, 0);
	}

	/**
	 * 야구게임 사이즈 체크
	 *
	 * @param argument
	 */
	@ParameterizedTest
	@ValueSource(ints = { 3 })
	void testArraySizeCheck(int num) {
		assertTrue(num == 3);
	}

	/**
	 * 야구게임 유효 값 체크
	 *
	 * @param argument
	 */
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
	void testValidNumberCheck(int num) {
		assertTrue(num > 0 && num < 10);
	}

}