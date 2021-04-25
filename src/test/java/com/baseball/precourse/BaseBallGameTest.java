package com.baseball.precourse;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author 김윤제
 *
 */
public class BaseBallGameTest {


//	@DisplayName("inputNumByPlayer")
//	@Test
//	void testinputNumByPlayer() {
//		BaseBallGame baseBallGame = new BaseBallGame();
//		try {
//			baseBallGame.inputNumByPlayer();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@DisplayName("judgementPlay")
	@Test
	void testjudgementPlay() {
		BaseBallGame baseBallGame = new BaseBallGame();
		Computer computer = new Computer();
		List<Integer> computerNums = computer.getRandomNums();

		try {
			String playerNums = baseBallGame.inputNumByPlayer();
			baseBallGame.judgmentPoint(computerNums, playerNums);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
