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
	
	private String isValidStatus(ArrayList<Integer> strategy) {
		if(isEnd) {
			return NOT_STARTED;
		}
		if(strategy.size() != 3 || strategy.contains(0)) {
			return NOT_VALID_PARAM;
		}
		return "";
	}
	
	private ArrayList<Integer> decodePlaceValue(int num) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int devideNum = 100;
		while(num != 0) {
			numbers = insertUniqueNumber(numbers, num/devideNum);
			num = num % devideNum;
			devideNum = devideNum/10;
		}
		return numbers;
	}
	
	private int compareNumber(int a, int b) {
		if(a == b) {
			return 1;
		}
		return 0;
	}
	
	private int calculateStrike(ArrayList<Integer> pitter, ArrayList<Integer> hitter) {
		int strike = 0;
		for(int i = 0; i < 3; i++) {
			strike += compareNumber(pitter.get(i), hitter.get(i));
		}
		return strike;
	}
	
	private int calculateBall(ArrayList<Integer> pitter, ArrayList<Integer> hitter) {
		int strike = calculateStrike(pitter, hitter);
		HashSet<Integer> union = new HashSet<Integer>();
		union.addAll(pitter);
		union.addAll(hitter);
		return 6 - union.size() - strike;
	}
	
	public void start() {
		isEnd = false;
		pitchingstrategy = makePitchingstrategy();
	}
	
	public String pitchAndHit(int ballCount) {
		ArrayList<Integer> hittingstrategy = decodePlaceValue(ballCount);
		String error = isValidStatus(hittingstrategy);
		if(!error.equals("")) {
			return error;
		}
		int strike = calculateStrike(pitchingstrategy, hittingstrategy);
		int ball = calculateBall(pitchingstrategy, hittingstrategy);
		return "";
	}
}