package com.nextstep.baseball;

import java.util.*;

public class BaseBall {

	Random randomGenerator = new Random();

	Scanner sc = new Scanner(System.in);

	public boolean play() {
		//1. 1~9까지 서로 다른 임의의 수 3개를 선택하여 리턴하는 기능
		List<Integer> answerList = selectNonoverlapThreeNumber();

		//2. 사용자로부터 1~9까지 서로 다른 임의의 수 3개를 입력 받는 기능
		printMessage("숫자를 입력해주세요 : ");
		//todo 입력에 대한 예외처리해야함.
		List<Integer> inputNumberList = readNonoverThreeNumber();

		//3. Strike, Ball 체크하는 기능
		List<Boolean> strikePosition = new ArrayList<>();
		do {
			strikePosition = detectStrike(answerList, inputNumberList);
			removeStrike(strikePosition, answerList, inputNumberList);
			int ballCount = detectBall(answerList, inputNumberList);
			boolean isNothing = isNothing(answerList);
		} while (strikePosition.size() == 0);

		return true;
	}

	private boolean isNothing(List<Integer> answerList) {
		if (answerList.size() == 3) {
			return true;
		}
		return false;
	}

	private int detectBall(List<Integer> answerList, List<Integer> inputNumberList) {
		answerList.retainAll(inputNumberList);
		return answerList.size();
	}

	private void removeStrike(List<Boolean> strikePosition, List<Integer> answerList, List<Integer> inputNumberList) {
		for (int i = 0; i < strikePosition.size(); i++) {
			removeStrike(strikePosition.get(i), answerList, inputNumberList, i);
		}
	}

	private void removeStrike(Boolean isStrike, List<Integer> answerList, List<Integer> inputNumberList, int index) {
		if (isStrike) {
			answerList.remove(index);
			inputNumberList.remove(index);
		}
	}

	private List<Boolean> detectStrike(List<Integer> answerList, List<Integer> inputNumberList) {
		List<Boolean> strikePosition = new ArrayList<>(Arrays.asList(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
		for (int i = 0; i < answerList.size(); i++) {
			Integer answer = answerList.get(i);
			Integer input = inputNumberList.get(i);

			detectStrike(answer, input, strikePosition, i);
		}

		return strikePosition;
	}

	private void detectStrike(Integer answer, Integer input, List<Boolean> strikePosition, int index) {
		if (answer == input) {
			strikePosition.add(index, Boolean.TRUE);
		}
	}

	private void collectDigits(int input, List<Integer> digits) {
		if (input / 10 > 0) {
			collectDigits(input / 10, digits);
		}
		digits.add(input % 10);
	}

	private List<Integer> readNonoverThreeNumber() {
		List<Integer> inputList = new ArrayList<Integer>();
		Integer input = sc.nextInt();
		collectDigits(input, inputList);
		return inputList;
	}

	private void printMessage(String message) {
		System.out.println(message);
	}

	private List<Integer> selectNonoverlapThreeNumber() {
		List<Integer> answerList = new ArrayList<>();
		HashSet<Integer> answerSet = new HashSet<>();
		do {
			int randomNum = randomGenerator.nextInt(9) + 1;
			answerList = addNonoverNumer(randomNum, answerSet, answerList);
		} while (answerSet.size() < 3);

		return answerList;
	}

	private List<Integer> addNonoverNumer(int randomNum, HashSet<Integer> answerSet, List<Integer> answerList) {
		if (answerSet.add(randomNum)) {
			answerList.add(randomNum);
		}
		return answerList;
	}
}
