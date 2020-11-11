package woo.baseball.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import woo.baseball.utils.BaseBallUtils;

/**
 * @author : chano
 * @Date   : 2020. 11. 11.
 * @Description : woo.baseball.utils 패키지에 대한 테스트.
 */
public class UtilTest {
	private int randomNumber;
	private int min = 100;
	private int max = 999;
	
	/**
	 * @author : chano
	 * @Date   : 2020. 11. 11.
	 * @Description : BaseBallUtils.ballNumberGenerator()를 실행하여 100미만이거나 999초과의 값이 나올경우 테스트실패함.
	 * @Method Name : utilTest
	 * @return : void
	 */
	@Test
	void utilTest() {
		for (int i = 0; i < 1000000; i++) {
			randomNumber = BaseBallUtils.ballNumberGenerator();
			assertTrue(min <= randomNumber && randomNumber <= max);
		}
	}
}
