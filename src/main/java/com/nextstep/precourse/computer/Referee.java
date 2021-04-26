package com.nextstep.precourse.computer;

import java.util.ArrayList;
import java.util.List;

import com.nextstep.precourse.util.InputValidator;

public class Referee {
	private int containsCount = 0;
	private int strikeCount = 0;
	private InputValidator validator = new InputValidator();

	public BaseBallResult getResult(List<Integer> answerList, String userInput) {
		String errorMessage = null;
		try {
			validator.validate(userInput);
			List<Integer> userInputList = changeUserInputStringToList(userInput);
			judgeUserInput(answerList, userInputList);
		} catch (IllegalArgumentException e) {
			errorMessage = e.getMessage();
		}

		return new BaseBallResult(containsCount, strikeCount, errorMessage);
	}

	public void initCount() {
		containsCount = 0;
		strikeCount = 0;
	}

	private void judgeUserInput(List<Integer> answerList, List<Integer> userInputList) {
		for (int index = 0; index < answerList.size(); index++) {
			plusContainsCount(answerList, userInputList.get(index));
			plusStrikeCount(answerList.get(index), userInputList.get(index));
		}
	}

	private void plusContainsCount(List<Integer> answerList, int userInput) {
		if (answerList.contains(userInput)) {
			containsCount++;
		}
	}

	private void plusStrikeCount(int answerNumber, int userInput) {
		if (answerNumber == userInput) {
			strikeCount++;
		}
	}

	private List<Integer> changeUserInputStringToList(String userInput) {
		String[] userStringInputArray = userInput.split("");
		List<Integer> userInputList = new ArrayList<>();
		for (String s : userStringInputArray) {
			userInputList.add(Integer.parseInt(s));
		}
		return userInputList;
	}
}
