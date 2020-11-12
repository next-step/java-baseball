package com.github.baekss.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import com.github.baekss.RandomNumberProvider;

public class Computer {

	private Set<Integer> threeDigitNumberSet;
	
	private Computer() {}

	public void setThreeDigitNumberSet(Set<Integer> threeDigitNumberSet) {
		this.threeDigitNumberSet = threeDigitNumberSet;
	}
	
	public Set<Integer> getThreeDigitNumberSet() {
		return threeDigitNumberSet;
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
