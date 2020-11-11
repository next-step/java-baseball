package woo.baseball.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import woo.baseball.utils.UiEnum;

/**
 * @author : chano
 * @Date : 2020. 11. 11.
 * @Description : woo.baseball.service의 Ui에 대한 테스트.
 */
public class UiTest {

	/**
	 * @author : chano
	 * @Date : 2020. 11. 11.
	 * @Description : UI 기능 테스트
	 * @Method Name : uiTest
	 * @return : void
	 */
	@Test
	void uiTest() {
		assertEquals(UiEnum.INPUTTEXT.text(), "숫자를 입력해주세요 : ");
		assertEquals(UiEnum.SUCCESSTEXT.text(), "개의 숫자를 모두 맞히셨습니다! 게임종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		assertEquals(UiEnum.STRIKE.text(), " 스트라이크");
		assertEquals(UiEnum.BALL.text(), " 볼");
	}

}
