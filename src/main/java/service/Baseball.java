package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import constants.GameNumberRule;
import constants.JudgeType;
import vo.GameNumber;
import vo.GameResult;

public class Baseball {
	private static Random random = new Random();

	public GameNumber createRandomGameNumber() {
		Set<Integer> numberSet = new HashSet<>();
		while (numberSet.size() < GameNumberRule.LENGTH.getValue()) {
			numberSet.add(random.nextInt(GameNumberRule.MAX_NUMBER.getValue()) + 1);
		}
		return new GameNumber(new ArrayList<>(numberSet));
	}

	public GameNumber convertNumberStringToGameNumber(String number) {
		ArrayList<Integer> numberList = new ArrayList<>();
		for (String numberString : number.split("")) {
			numberList.add(Integer.parseInt(numberString));
		}
		return new GameNumber(numberList);
	}

	public GameResult getGameResult(GameNumber comNumber, GameNumber userNumber) {
		ArrayList<String> judgeNumberResultList = new ArrayList<>();
		for (int i = 0; i < userNumber.getGameNumberList().size(); i++) {
			judgeNumberResultList.add(judgeNumber(comNumber, userNumber, i));
		}
		return countJudgeTypeFromJudgeNumberResultList(judgeNumberResultList);
	}

	public String judgeNumber(GameNumber comNumber, GameNumber userNumber, int index) {
		if (isStrike(comNumber, userNumber, index)) {
			return JudgeType.STRIKE.name();
		}
		if (isBall(comNumber, userNumber, index)) {
			return JudgeType.BALL.name();
		}
		return JudgeType.NOTHING.name();
	}

	public boolean isStrike(GameNumber comNumber, GameNumber userNumber, int index) {
		return comNumber.getGameNumberList().get(index).equals(userNumber.getGameNumberList().get(index));
	}

	public boolean isBall(GameNumber comNumber, GameNumber userNumber, int index) {
		return !isStrike(comNumber, userNumber, index)
			&& comNumber.getGameNumberList().contains(userNumber.getGameNumberList().get(index));
	}

	public GameResult countJudgeTypeFromJudgeNumberResultList(List<String> judgeNumberResultList) {
		return new GameResult(
			Collections.frequency(judgeNumberResultList, JudgeType.STRIKE.name()),
			Collections.frequency(judgeNumberResultList, JudgeType.BALL.name()),
			Collections.frequency(judgeNumberResultList, JudgeType.NOTHING.name())
		);
	}
}
