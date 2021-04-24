package com.baseball.precourse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author 김윤제
 *
 */
class ComputerTest {

	@DisplayName("getRandomNums")
	@Test
	void testgetRandomNums() {
		Computer computer = new Computer();
		assertTrue(computer.getRandomNums().size() == 3);
	}
}
