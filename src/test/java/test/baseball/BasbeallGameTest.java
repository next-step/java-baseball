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
	 * ���� �� ��ȿ�� �˻�
	 */
	@Test
	public void testRandomValid() {
		testArraySizeCheck(randomNumArr.length);
		for (int randomNum : randomNumArr) {
			testValidNumberCheck(randomNum);
		}
	}

	/**
	 * ��ǲ �� ��ȿ�� �˻�
	 */
	@Test
	public void testInputNumValid() {
		testArraySizeCheck(inputNumArr.length);
		for (int inputNum : inputNumArr) {
			testValidNumberCheck(inputNum);
		}
	}

	/**
	 * �߱����� ��� ī��Ʈ Ȯ��
	 */
	@Test
	public void testBaseballCount() {
		// value,index�� ��� ���Ͻ� strike ++
		testGame.checkBaseballCount(3, 3, 3, 3);
		// value�� ���� index�� �ٸ� �� ball ++
		testGame.checkBaseballCount(3, 3, 2, 3);

		assertEquals(testGame.getBall(), 1);
		assertEquals(testGame.getStrike(), 1);
	}

	/**
	 * �߱����� ī��Ʈ ���� Ȯ��
	 */
	@Test
	public void testBaseballReset() {
		testGame.resetBaseballCount();

		assertEquals(testGame.getBall(), 0);
		assertEquals(testGame.getStrike(), 0);
	}

	/**
	 * ���� �� Ȯ��
	 */
	@Test
	public void testEqualToNum() {
		// �񱳰��� ��ġ�Ҷ� 1, �ٸ��� 0 return
		int testEqual = testGame.equalToNum(1, 1);
		int testNotEqual = testGame.equalToNum(1, 2);

		assertEquals(testEqual, 1);
		assertEquals(testNotEqual, 0);
	}

	/**
	 * �߱����� ������ üũ
	 *
	 * @param argument
	 */
	@ParameterizedTest
	@ValueSource(ints = { 3 })
	void testArraySizeCheck(int num) {
		assertTrue(num == 3);
	}

	/**
	 * �߱����� ��ȿ �� üũ
	 *
	 * @param argument
	 */
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
	void testValidNumberCheck(int num) {
		assertTrue(num > 0 && num < 10);
	}

}