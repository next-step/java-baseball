package woo.baseball.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import woo.baseball.service.InputService;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : woo.baseball.utils 패키지에 대한 테스트.
 */
public class NumberTest {
	private int randomNumber;
	private int min = 100;
	private int max = 999;

	/**
	 * @author : chano
	 * @Date : 2020. 11. 11.
	 * @Description : BaseBallUtils.ballNumberGenerator()를 실행하여 100미만이거나 999초과의 값이
	 *              나올경우 테스트실패함.
	 * @Method Name : utilTest
	 * @return : void
	 */
	@Test
	void randomNumberTest() {
		for (int i = 0; i < 1000000; i++) {
			randomNumber = InputService.ballNumberGenerator();
			assertTrue(min <= randomNumber && randomNumber <= max);
		}
	}

	/**
	 * @author : chano
	 * @Date : 2020. 11. 11.
	 * @Description : BaseBallUtils.inputNumber() 입력기능 테스트이며 100미만이거나 999초과의 값이 나올경우
	 *              테스트실패함.
	 * @Method Name : inputNumberTest
	 * @return : void
	 */
	@Test
	void inputNumberTest() {
	//	userNumber = NumberUtils.inputNumber();
	//	assertTrue(min <= userNumber && userNumber <= max);
	}

}
