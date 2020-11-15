package com.coderhglee.game.number;

import com.coderhglee.game.domain.GameGroupsCompareResult;
import com.coderhglee.game.number.GameNumber;
import com.coderhglee.game.number.GameNumberGroups;
import com.coderhglee.game.number.GameSettingNumbers;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGroupsHelper {
    public static GameGroupsCompareResult compareEachGameGroup(GameNumberGroups criteriaGameNumberGroups, GameNumberGroups targetGameNumberGroups) {
        int numberSameScore = getRetainGameNumbersSize(criteriaGameNumberGroups, targetGameNumberGroups);
        int numberAndDigitSameScore = 0;
        for (int compareIndexNumber = 0; compareIndexNumber < GameSettingNumbers.INPUT_MESSAGE_MAX_LENGTH.value; compareIndexNumber++) {
            numberAndDigitSameScore += calculationDigitSameScore(criteriaGameNumberGroups.getGameNumberByIndex(compareIndexNumber),
                    targetGameNumberGroups.getGameNumberByIndex(compareIndexNumber));
        }
        numberSameScore -= numberAndDigitSameScore;
        return new GameGroupsCompareResult(numberSameScore, numberAndDigitSameScore);
    }

    private static int getRetainGameNumbersSize(GameNumberGroups criteriaGameNumberGroups, GameNumberGroups targetGameNumberGroups) {
        List<GameNumber> retainList = new ArrayList<>(criteriaGameNumberGroups.getGameNumbers());
        retainList.retainAll(targetGameNumberGroups.getGameNumbers());
        return retainList.size();
    }

    private static int calculationDigitSameScore(GameNumber criteriaGameNumber, GameNumber targetGameNumber) {
        if (criteriaGameNumber.equals(targetGameNumber)) {
            return GameSettingNumbers.ADD_ONE_SCORE.value;
        }
        return GameSettingNumbers.ADD_ZERO_SCORE.value;
    }
}
