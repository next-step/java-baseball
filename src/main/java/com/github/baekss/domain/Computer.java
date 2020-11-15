package com.github.baekss.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import com.github.baekss.RandomNumberProvider;

public class Computer {

	private Set<Integer> threeDigitNumberSet;
	private final int THREE_STRIKE_OUT = 3;
	
	private Computer() {}

	public void setThreeDigitNumberSet(Set<Integer> threeDigitNumberSet) {
		this.threeDigitNumberSet = threeDigitNumberSet;
	}
	
	public Set<Integer> getThreeDigitNumberSet() {
		return threeDigitNumberSet;
	}
	
	/**
	 * 플레이어가 입력한 숫자와 컴퓨터의 숫자를 비교한다.
	 * @param inputNumberSet 플레이어가 입력한 숫자
	 * @return 3스트라이크 여부
	 */
	public boolean compareInputNumberToComputerNumbers(Set<Integer> inputNumberSet) {
		Iterator<Integer> inputNumberIter = inputNumberSet.iterator();
		Iterator<Integer> computerNumberIter = threeDigitNumberSet.iterator();
		Map<String, Integer> resultMap = new HashMap<>();
		while (inputNumberIter.hasNext()) {
			Integer inputNumber = inputNumberIter.next();
			makeResult(inputNumber, computerNumberIter, resultMap);
		}
		printResult(resultMap);
		return resultMap.get("strike") == THREE_STRIKE_OUT;
	}
	
	private void makeResult(Integer inputNumber, Iterator<Integer> computerNumberIter, Map<String, Integer> resultMap) {
		resultMap.putIfAbsent("strike", new Integer(0));
		resultMap.putIfAbsent("ball", new Integer(0));
		
		/* 스트라이크 여부를 먼저 판단한 후 결과에 따라 볼 여부를 판단 */
		if (isStrike(inputNumber, computerNumberIter)) {
			Integer strikeCount = resultMap.get("strike");
			resultMap.put("strike", Integer.sum(strikeCount, new Integer(1)));
		} else if (isBall(inputNumber)) {
			Integer ballCount = resultMap.get("ball");
			resultMap.put("ball", Integer.sum(ballCount, new Integer(1)));
		}
	}
	
	private boolean isStrike(Integer inputNumber, Iterator<Integer> computerNumberIter) {
		if (computerNumberIter.hasNext()) {
			Integer computerNumber = computerNumberIter.next();
			return inputNumber.equals(computerNumber);
		}
		return false;
	}
	
	private boolean isBall(Integer inputNumber) {
		return threeDigitNumberSet.contains(inputNumber);
	}
	
	private void printResult (Map<String, Integer> resultMap) {
		String message = "";
		
		if (resultMap.get("strike") > 0) {
			message += resultMap.get("strike") + "스트라이크 ";
		}
		
		if (resultMap.get("ball") > 0) {
			message += resultMap.get("ball") + "볼";
		}
		System.out.println(message.isEmpty() ? "낫싱" : message);
	}
	
	/**
	 * Computer 객체를 정적 메소드를 이용해 생성 및 초기화한다.
	 * @param maxSize Computer가 갖는 서로다른 임의의 수 사이즈
	 * @param minNumber 제공할 랜덤 숫자 범위 중에서 최소 값
	 * @param maxNumber 제공할 랜덤 숫자 범위 중에서 최대 값
	 * @return Computer 객체
	 */
	public static Computer createComputer(int maxSize, int minNumber, int maxNumber) {
		Computer computer = new Computer();
		Set<Integer> set = new LinkedHashSet<>(); // 순서를 보장하며 중복값을 허용하지 않는 자료구조
		while (set.size() < maxSize) {
			Integer randomNumber = RandomNumberProvider.provideRandomNumber(minNumber, maxNumber);
			set.add(randomNumber);
		}
		computer.setThreeDigitNumberSet(set);
		return computer;
	}
}
