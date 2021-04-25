package com.baseball.precourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author 김윤제
 *
 */
public class BaseBallGameTest {


	@DisplayName("inputNumByPlayer")
	@Test
	void testinputNumByPlayer() {
		BaseBallGame baseBallGame = new BaseBallGame();
		try {
			baseBallGame.inputNumByPlayer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
