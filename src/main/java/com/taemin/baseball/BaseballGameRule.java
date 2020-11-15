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
	
	public boolean isWin(LinkedHashSet<Integer> computerNumbers, LinkedHashSet<Integer> userNumbers) throws Exception {
		if(getStrikeCount(computerNumbers, userNumbers) == 3) {
			System.out.println("3개 숫자를 모두 맞추셨습니다! 게임 종료");
			return true;
		}
		String hintComment = "";
		if(getStrikeCount(computerNumbers, userNumbers) > 0)
			hintComment += getStrikeCount(computerNumbers, userNumbers) + " 스트라이크";
		
		if(getBallCount(computerNumbers, userNumbers) > 0)
			hintComment += getBallCount(computerNumbers, userNumbers) + " 볼";
		
		if(getBallCount(computerNumbers, userNumbers) == 0 && getStrikeCount(computerNumbers, userNumbers) == 0)
			hintComment = "낫싱";
		
		System.out.println(hintComment);
		return false;
		
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
	
	public int getBallCount(LinkedHashSet<Integer> computerNumbers, LinkedHashSet<Integer> userNumbers) throws Exception {
		int ballCount = 0;
		if(computerNumbers == null)
			throw new Exception("Computer Numbers are null");
		if(userNumbers == null)
			throw new Exception("User Numbers are null");
		
		
		int[] userNumberArray = toIntArrayAtIntSet(userNumbers);
		for(int index = 0; index < 3; index++)
			ballCount += isBall(computerNumbers, userNumberArray[index]);
		ballCount = ballCount - getStrikeCount(computerNumbers, userNumbers);
		return ballCount;
	}
	
	private int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(9) + 1;
	}
	
	private int isStrike(int computerNumber, int userNumber) {
		if(computerNumber == userNumber)
			return 1;
		return 0;
	}
	
	private int isBall(LinkedHashSet<Integer> computerNumbers, int userNumber) {
		if(computerNumbers.contains(userNumber))
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
