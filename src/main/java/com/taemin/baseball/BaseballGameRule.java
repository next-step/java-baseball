package com.taemin.baseball;
import java.util.LinkedHashSet;
import java.util.Random;

public class BaseballGameRule {

	public LinkedHashSet<Integer> getComputerRandomNumbers() {
		
		LinkedHashSet<Integer> computerRandomNumbers = new LinkedHashSet<Integer>();
		while(computerRandomNumbers.size() != 3)
			computerRandomNumbers.add(getRandomNumber());
		return computerRandomNumbers;
	}
	
	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9) + 1;
	}
	
	
}
