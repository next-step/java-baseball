package com.nextstep.baseball;

import java.util.*;

public class BaseBall {

	Random randomGenerator = new Random();

	Scanner sc = new Scanner(System.in);

	public void start() {
		//4. 게임 재시작 또는 종료 기능
		String restart = null;
		do {
			playGame();
			printMessage("3개 숫자를 모두 맞히셨습니다. 게임 종료");
			printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			restart = sc.next();
		} while (Boolean.valueOf(restart));

	}

	public void playGame() {
		int strikeCnt = 0;
		do {
			List<Integer> answerList = selectNonoverlapThreeNumber();
			printMessage("숫자를 입력해주세요 : ");
			List<Integer> inputNumberList = readNonoverThreeNumber(sc.nextInt());
			List<Boolean> strikePosition = detectStrike(answerList, inputNumberList);
			int ballCount = detectBall(strikePosition, answerList, inputNumberList);
			boolean isNothing = isNothing(answerList, ballCount);
			strikeCnt = calcuateStrike(strikePosition);
			printResult(strikeCnt, ballCount, isNothing); //결과 출력
		} while (strikeCnt < 3);
	}

	public void printResult(int strikeCnt, int ballCount, boolean isNothing) {
		StringBuffer sb = new StringBuffer();
		if (isNothing) {
			sb.append("낫싱");
		}
		if (strikeCnt != 0) {
			sb.append(String.format("%s 스트라이크", strikeCnt));
		}
		if (ballCount != 0) {
			sb.append(String.format("%s 볼", ballCount));
		}
		System.out.println(sb.toString());
	}

	private int calcuateStrike(List<Boolean> strikePosition) {
		int strikeCnt = 0;
		for (int i = 0; i < strikePosition.size(); i++) {
			strikeCnt += calcuateStrike(strikePosition.get(i));
		}
		return strikeCnt;
	}

	private int calcuateStrike(Boolean isStrike) {
		if (isStrike) {
			return 1;
		}
		return 0;
	}

	boolean isNothing(List<Integer> answerList, int ballCount) {
		if (answerList.size() == 0 && ballCount != 3) {
			return true;
		}
		return false;
	}

	int detectBall(List<Boolean> strikePosition, List<Integer> answerList, List<Integer> inputNumberList) {
		removeStrike(strikePosition, answerList, inputNumberList);
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

	List<Boolean> detectStrike(List<Integer> answerList, List<Integer> inputNumberList) {
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
			strikePosition.set(index, Boolean.TRUE);
		}
	}

	void collectDigits(int input, List<Integer> digits) {
		if (input / 10 > 0) {
			collectDigits(input / 10, digits);
		}
		digits.add(input % 10);
	}

	List<Integer> readNonoverThreeNumber(int input) {
		List<Integer> inputList = new ArrayList<Integer>();
		collectDigits(input, inputList);
		return inputList;
	}

	private void printMessage(String message) {
		System.out.println(message);
	}

	List<Integer> selectNonoverlapThreeNumber() {
		List<Integer> answerList = new ArrayList<>();
		HashSet<Integer> answerSet = new HashSet<>();
		do {
			int randomNum = randomGenerator.nextInt(9) + 1;
			answerList = addNonoverNumer(randomNum, answerSet, answerList);
		} while (answerSet.size() < 3);

		return answerList;
	}

	List<Integer> addNonoverNumer(int randomNum, HashSet<Integer> answerSet, List<Integer> answerList) {
		if (answerSet.add(randomNum)) {
			answerList.add(randomNum);
		}
		return answerList;
	}
}
