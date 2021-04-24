package com.baseball.precourse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author 김윤제
 *
 */
public class PlayerTest {
	
	@DisplayName("playerSelectNums")
	@Test
	void testPlayerSelectNums() {
		Player player = new Player();
		try {
			player.selectNums();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
