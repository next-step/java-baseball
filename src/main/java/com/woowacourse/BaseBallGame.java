package com.woowacourse;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class BaseBallGame {
	public static void main(String[] args) {
		BaseBallGame baseBallGame = new BaseBallGame();
		baseBallGame.setInit();
	}
	
	/* �ʱⰪ ���� */
	public void setInit() {
		Map<Integer, Integer> randomNumber = new LinkedHashMap<Integer, Integer>(); 
		setRandomNumber(randomNumber);
	}
	
	/* �������� ���� */
	public void setRandomNumber(Map<Integer, Integer> randomNumber) {
		if (randomNumber.size() == 3) {
			return;
		}
		
		Random randomNum = new Random();
		int num = (int)(randomNum.nextInt(9)) + 1;
		
		if (!randomNumber.containsKey(num)) {
			randomNumber.put(num, randomNumber.size());
		}

		setRandomNumber(randomNumber);
	}
}
