package com.taemin.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballGameRuleTest {

	@Test
	void _getComputerRandomNumbers() {
		
		BaseballGameRule baseballGameRule = new BaseballGameRule();
		assertNotNull(baseballGameRule.getComputerRandomNumbers());
		assertSame(3, baseballGameRule.getComputerRandomNumbers().size());
		System.out.println(baseballGameRule.getComputerRandomNumbers());

		
	}

}
