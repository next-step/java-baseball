package com.baseballgame.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import com.baseballgame.common.BaseBallCounter;

public class Computer {

	private String answerNumber;

	/**
	 * 베이스볼 숫자 생성
	 * @return
	 */
	public void makeBaseballNumber() {
		Set<Integer> randomNumberSet = new HashSet<>();

		Random random = new Random();
		while (randomNumberSet.size() < 3) {
			randomNumberSet.add(random.nextInt(9) + 1);
		}

		answerNumber = randomNumberSet.stream()
			.unordered()
			.map(randomNumber -> randomNumber.toString())
			.reduce("", (a, b) -> a + b);
	}

	/**
	 * 사용자가 제출한 답안 채점
	 * @param userAnswer
	 * @return
	 */
	public boolean isAllMatches(String userAnswer) {
		Map<BaseBallCounter, Integer> baseBallCounterIntegerMap = new HashMap<>();

		for (int i=0; i < answerNumber.length(); i++){
			loopUserAnswer(userAnswer, baseBallCounterIntegerMap, i);
		}

		if (isThreeStrike(baseBallCounterIntegerMap)){
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			return true;
		}

		printScoreResult(baseBallCounterIntegerMap);
		return false;
	}

	private void printScoreResult(Map<BaseBallCounter, Integer> baseBallCounterIntegerMap) {

		makeOutData(baseBallCounterIntegerMap);

		for (BaseBallCounter key : baseBallCounterIntegerMap.keySet()){
			System.out.printf("%d %s ", baseBallCounterIntegerMap.get(key), key);
		}
		System.out.println();
	}

	private void makeOutData(Map<BaseBallCounter, Integer> baseBallCounterIntegerMap) {
		Set<BaseBallCounter> keySet = baseBallCounterIntegerMap.keySet();
		int countOfStrikeAndBall = 0;

		for (BaseBallCounter key : baseBallCounterIntegerMap.keySet()) {
			countOfStrikeAndBall += baseBallCounterIntegerMap.get(key);
		}

		baseBallCounterIntegerMap.put(BaseBallCounter.OUT, answerNumber.length() - countOfStrikeAndBall);
	}

	private boolean isThreeStrike(Map<BaseBallCounter, Integer> baseBallCounterIntegerMap) {
		if (!baseBallCounterIntegerMap.containsKey(BaseBallCounter.STRIKE)){
			return false;
		}

		int strikeCount = baseBallCounterIntegerMap.get(BaseBallCounter.STRIKE);
		if (!Objects.isNull(strikeCount) && strikeCount == 3) {
			return true;
		}
		return false;
	}

	private void loopUserAnswer(String userAnswer, Map<BaseBallCounter, Integer> baseBallCounterIntegerMap, int i) {
		for (int j = 0; j < userAnswer.length(); j++){
			makeMapData(userAnswer, baseBallCounterIntegerMap, i, j);
		}
	}

	private void makeMapData(String userAnswer, Map<BaseBallCounter, Integer> baseBallCounterIntegerMap, int i, int j) {
		if (answerNumber.substring(i, i + 1).equals(userAnswer.substring(j, j + 1))){
			classifyCounter(baseBallCounterIntegerMap, i, j);
		}
	}

	private void classifyCounter(Map<BaseBallCounter, Integer> baseBallCounterIntegerMap, int i, int j) {
		if (i == j) {
			baseBallCounterIntegerMap.put(BaseBallCounter.STRIKE, baseBallCounterIntegerMap.getOrDefault(BaseBallCounter.STRIKE, 0) + 1);
			return;
		}

		baseBallCounterIntegerMap.put(BaseBallCounter.BALL, baseBallCounterIntegerMap.getOrDefault(BaseBallCounter.BALL, 0) + 1);
	}

}
