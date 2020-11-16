package com.coderhglee.game.number;

import java.util.ArrayList;
import java.util.List;

import com.coderhglee.game.GameSettingProperties;


public class NumberGroupsHelper {
	public static NumberCompareResult compareEachNumber(NumberGroups criteriaGroups, NumberGroups targetGroups) {
		int numberSameScore = getRetainGameNumbersSize(criteriaGroups, targetGroups);
		int numberAndDigitSameScore = 0;
		int inputMessageMaxLength = GameSettingProperties.INPUT_MESSAGE_MAX_LENGTH.value;
		for (int compareIndexNumber = 0; compareIndexNumber < inputMessageMaxLength; compareIndexNumber++) {
			numberAndDigitSameScore += calculationDigitSameScore(criteriaGroups, targetGroups, compareIndexNumber);
		}
		numberSameScore -= numberAndDigitSameScore;
		return new NumberCompareResult(numberSameScore, numberAndDigitSameScore);
	}

	private static int getRetainGameNumbersSize(NumberGroups criteriaGroups, NumberGroups targetGroups) {
		List<Number> retainList = new ArrayList<>(criteriaGroups.getGameNumbers());
		retainList.retainAll(targetGroups.getGameNumbers());
		return retainList.size();
	}

	private static int calculationDigitSameScore(NumberGroups criteriaGroups, NumberGroups targetGroups, int nowIndex) {
		Number criteriaNumber = criteriaGroups.getGameNumberByIndex(nowIndex);
		Number targetNumber = targetGroups.getGameNumberByIndex(nowIndex);
		if (criteriaNumber.equals(targetNumber)) {
			return GameSettingProperties.ADD_ONE_SCORE.value;
		}
		return GameSettingProperties.ADD_ZERO_SCORE.value;
	}
}
