package woo.baseball.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import woo.baseball.type.UiType;

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
		assertEquals(UiType.INPUT_TEXT.text(), "숫자를 입력해주세요 : ");
		assertEquals(UiType.SUCCESS_TEXT.text(), "개의 숫자를 모두 맞히셨습니다! 게임종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		assertEquals(UiType.STRIKE.text(), " 스트라이크");
		assertEquals(UiType.BALL.text(), " 볼");
	}

}
