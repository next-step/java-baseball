package woo.baseball.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import woo.baseball.service.InputService;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : woo.baseball.utils 패키지에 대한 테스트.
 */
public class InputTest {

	/**
	 * @author : chano
	 * @Date : 2020. 11. 11.
	 * @Description : BaseBallUtils.ballNumberGenerator()를 실행하여 100미만이거나 999초과의 값이
	 *              나올경우 테스트실패함.
	 * @Method Name : validationNumber
	 * @return : void
	 */
	@Test
	@DisplayName("validationNumber Test")
	void validationNumber() {
	  assertTrue(InputService.validDistinctNumber(133));
	  assertThat(InputService.validDistinctNumber(143));
    
	}


}
