package com.coderhglee.game.number;

import com.coderhglee.game.GameSettingProperties;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGroupsHelper {
    public static GameNumberCompareResult compareEachGameGroup(GameNumberGroups criteriaGameNumberGroups, GameNumberGroups targetGameNumberGroups) {
        int numberSameScore = getRetainGameNumbersSize(criteriaGameNumberGroups, targetGameNumberGroups);
        int numberAndDigitSameScore = 0;
        for (int compareIndexNumber = 0; compareIndexNumber < GameSettingProperties.INPUT_MESSAGE_MAX_LENGTH.value; compareIndexNumber++) {
            numberAndDigitSameScore += calculationDigitSameScore(criteriaGameNumberGroups.getGameNumberByIndex(compareIndexNumber),
                    targetGameNumberGroups.getGameNumberByIndex(compareIndexNumber));
        }
        numberSameScore -= numberAndDigitSameScore;
        return new GameNumberCompareResult(numberSameScore, numberAndDigitSameScore);
    }

    private static int getRetainGameNumbersSize(GameNumberGroups criteriaGameNumberGroups, GameNumberGroups targetGameNumberGroups) {
        List<GameNumber> retainList = new ArrayList<>(criteriaGameNumberGroups.getGameNumbers());
        retainList.retainAll(targetGameNumberGroups.getGameNumbers());
        return retainList.size();
    }

    private static int calculationDigitSameScore(GameNumber criteriaGameNumber, GameNumber targetGameNumber) {
        if (criteriaGameNumber.equals(targetGameNumber)) {
            return GameSettingProperties.ADD_ONE_SCORE.value;
        }
        return GameSettingProperties.ADD_ZERO_SCORE.value;
    }
}
