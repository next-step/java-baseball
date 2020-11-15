package com.taemin.baseball;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

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
	
	public int getStrikeCount(LinkedHashSet<Integer> computerNumbers, LinkedHashSet<Integer> userNumbers) throws Exception {
		int strikeCount = 0;
		if(computerNumbers == null)
			throw new Exception("Computer Numbers are null");
		if(userNumbers == null)
			throw new Exception("User Numbers are null");
		int[] computerNumberArray = toIntArrayAtIntSet(computerNumbers);
		int[] userNumberArray = toIntArrayAtIntSet(userNumbers);
		
		for(int index = 0; index < 3; index++)
			strikeCount += isStrike(computerNumberArray[index], userNumberArray[index]);	
		return strikeCount;
	}
	
	private int isStrike(int computerNumber, int userNumber) {
		if(computerNumber == userNumber)
			return 1;
		return 0;
	}
	
	private int[] toIntArrayAtIntSet(Set<Integer> set) {
		int[] intArray = new int[set.size()];
		int index = 0;
		Iterator<Integer> setIterator = set.iterator();
		while(setIterator.hasNext()) {
			intArray[index] = setIterator.next();
			index++;
		}
			
		return intArray;
		
	}
	
}
