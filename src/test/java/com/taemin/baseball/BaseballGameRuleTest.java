package com.taemin.baseball;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedHashSet;
import org.junit.jupiter.api.Test;

class BaseballGameRuleTest {

	@Test
	void _getComputerRandomNumbers() {
		
		BaseballGameRule baseballGameRule = new BaseballGameRule();
		assertNotNull(baseballGameRule.getComputerRandomNumbers());
		assertSame(3, baseballGameRule.getComputerRandomNumbers().size());
		System.out.println(baseballGameRule.getComputerRandomNumbers());

		
	}
	
	@Test 
	void _getStrikeCount() throws Exception {
		BaseballGameRule baseballGameRule = new BaseballGameRule();
		LinkedHashSet<Integer> computerNumbers = baseballGameRule.getComputerRandomNumbers();
		LinkedHashSet<Integer> userNumbers = baseballGameRule.getComputerRandomNumbers();
		System.out.println("Computer Numbers" + computerNumbers);
		System.out.println("User Numbers" + userNumbers);
		assertNotNull(computerNumbers);
		assertNotNull(userNumbers);
		assertSame(3, computerNumbers.size());
		assertSame(3, userNumbers.size());
		assertTrue(baseballGameRule.getStrikeCount(computerNumbers, userNumbers) <= 3);
		System.out.println(baseballGameRule.getStrikeCount(computerNumbers, userNumbers));
	}
	

}
