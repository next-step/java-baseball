package com.github.baekss;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberProvider {
	
	private static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
	
	/**
	 * 랜덤 숫자를 제공한다.
	 * @param minNumber 제공할 랜덤 숫자 범위 중에서 최소 값
	 * @param maxNumber 제공할 랜덤 숫자 범위 중에서 최대 값
	 * @return 랜덤 숫자(만일, 추출된 랜덤 숫자가 minNumber보다 작을시 minNumber가 return됨)
	 */
	public static int provideRandomNumber(int minNumber, int maxNumber) {
		int randomNumber = threadLocalRandom.nextInt(maxNumber+1);
		if(randomNumber < minNumber) {
			randomNumber = minNumber;
		}
		return randomNumber;
	}
}
