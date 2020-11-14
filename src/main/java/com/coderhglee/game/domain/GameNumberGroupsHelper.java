package com.coderhglee.game.domain;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGroupsHelper {
    public static GameGroupsCompareResult compareEachGameGroup(GameNumberGroups criteriaGameNumberGroups, GameNumberGroups targetGameNumberGroups) {
        int numberSameScore = getRetainGameNumbersSize(criteriaGameNumberGroups, targetGameNumberGroups);
        int numberAndDigitSameScore = 0;
        for (int compareIndexNumber = 0; compareIndexNumber < GameNumberGroups.MESSAGE_ALLOW_LENGTH_MAX; compareIndexNumber++) {
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
            return 1;
        }
        return 0;
    }
}
