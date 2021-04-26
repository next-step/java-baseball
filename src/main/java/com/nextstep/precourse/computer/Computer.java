package com.nextstep.precourse.computer;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {
	private static final int ANSWER_LENGTH = 3;

	private static final int RESULT_ARRAY_IDX_STRIKE = 0;
	private static final int RESULT_ARRAY_IDX_BALL = 1;

	private Random random;
	private String answer;

	public Computer() {
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			random = new Random();
		}
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String generateNewAnswer() {
		String newAnswer = "";
		List<Integer> selectedNumber = new ArrayList<>();
		while (newAnswer.length() != ANSWER_LENGTH) {
			newAnswer += generateRandomOneNumber(random, selectedNumber);
		}
		this.answer = newAnswer;
		return newAnswer;
	}

	private String generateRandomOneNumber(Random random, List<Integer> selectedNumber) {
		int randomNumber = random.nextInt(9) + 1;
		if (!selectedNumber.contains(randomNumber)) {
			selectedNumber.add(randomNumber);
			return Integer.toString(randomNumber);
		}
		return "";
	}

	public void ready() {
		generateNewAnswer();
	}

	public boolean checkAnswer(String userInput) {
		int[] checkResult = checkStrikeBall(userInput, answer);
		return checkGameEnd(checkResult);
	}

	public int[] checkStrikeBall(String userInput, String answer) {
		int[] checkResult = new int[2];
		for (int index = 0; index < ANSWER_LENGTH; index++) {
			checkResult[RESULT_ARRAY_IDX_STRIKE] += (userInput.charAt(index) == answer.charAt(index)) ? 1 : 0;
			checkResult[RESULT_ARRAY_IDX_BALL] += isBall(answer, userInput.charAt(index), index) ? 1 : 0;
		}
		return checkResult;
	}

	private boolean isBall(String answer, char currentInput, int currentIndex) {
		int prevIndex = ((currentIndex + 2) % 3);
		int nextIndex = ((currentIndex + 1) % 3);

		if (currentInput == answer.charAt(prevIndex)) {
			return true;
		}
		if (currentInput == answer.charAt(nextIndex)) {
			return true;
		}
		return false;
	}

	public boolean checkGameEnd(int[] examResult) {
		printScore(examResult);

		if (examResult[RESULT_ARRAY_IDX_STRIKE] == ANSWER_LENGTH) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			return true;
		}
		return false;
	}

	private void printScore(int[] examResult) {
		if (examResult[RESULT_ARRAY_IDX_STRIKE] > 0) {
			System.out.print(String.format("%d 스트라이크 ", examResult[RESULT_ARRAY_IDX_STRIKE]));
		}
		if (examResult[RESULT_ARRAY_IDX_BALL] > 0) {
			System.out.print(String.format("%d 볼", examResult[RESULT_ARRAY_IDX_BALL]));
		}
		if (examResult[RESULT_ARRAY_IDX_STRIKE] == 0 && examResult[RESULT_ARRAY_IDX_BALL] == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}
}
