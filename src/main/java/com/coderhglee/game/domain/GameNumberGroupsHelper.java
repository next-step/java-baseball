package com.coderhglee.game.domain;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGroupsHelper {
    public static GameGroupsCompareResult compareEachGameGroup(GameNumberGroups criteriaGameNumberGroups, GameNumberGroups targetGameNumberGroups) {
        List<GameNumber> retainList = getRetainGameNumbers(criteriaGameNumberGroups, targetGameNumberGroups);
        int numberSameScore = retainList.size();
        int numberAndDigitSameScore = 0;
        for (int compareIndexNumber = 0; compareIndexNumber < GameNumberGroups.MESSAGE_ALLOW_LENGTH_MAX; compareIndexNumber++) {
            numberAndDigitSameScore += calculationDigitSameScore(criteriaGameNumberGroups.getGameNumberByIndex(compareIndexNumber),
                    targetGameNumberGroups.getGameNumberByIndex(compareIndexNumber));
        }
        return new GameGroupsCompareResult(numberSameScore - numberAndDigitSameScore, numberAndDigitSameScore);
    }

    private static List<GameNumber> getRetainGameNumbers(GameNumberGroups criteriaGameNumberGroups, GameNumberGroups targetGameNumberGroups) {
        List<GameNumber> retainList = new ArrayList<>(criteriaGameNumberGroups.getGameNumbers());
        retainList.retainAll(targetGameNumberGroups.getGameNumbers());
        return retainList;
    }

    private static int calculationDigitSameScore(GameNumber criteriaGameNumber, GameNumber targetGameNumber) {
        if (criteriaGameNumber.equals(targetGameNumber)) {
            return 1;
        }
        return 0;
    }
}
