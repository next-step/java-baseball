package com.nextstep.baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class BaseballInning {
	public final String NOT_STARTED = "아직 시작되지 않았습니다.";
	public final String NOT_VALID_PARAM = "잘못된 값이 입력되었습니다.";
	public final String STRIKE = "스트라이크";
	public final String BALL = "볼";
	public final String NOTHING = "낫싱";
	
	private boolean isEnd;
	private ArrayList<Integer> pitchingstrategy;
	
	public BaseballInning() {
		init();
	}
	
	public void init() {
		isEnd = true;
		pitchingstrategy = null;
	}
	
	private ArrayList<Integer> insertUniqueNumber(ArrayList<Integer> numbers, int number) {
		if(numbers.contains(number)) {
			return numbers;
		}
		numbers.add(number);
		return numbers;
	}
	
	private int getRandomNumber(int min, int max) {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		int num = random.nextInt(max) + min;
		return num;
	}
	
	private ArrayList<Integer> makePitchingstrategy() {
		int min = 1, max = 9;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		while(numbers.size()  < 3) {
			int n = getRandomNumber(min, max);
			numbers = insertUniqueNumber(numbers, n);
		}
		return numbers;
	}
	
	public void start() {
		isEnd = false;
		pitchingstrategy = makePitchingstrategy();
	}
}