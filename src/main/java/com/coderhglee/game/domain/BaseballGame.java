package com.coderhglee.game.domain;

import com.coderhglee.game.exception.GameException;

public class BaseballGame {
    GameNumberGroups correctAnswer;

    public BaseballGame(InputNumber inputNumber) throws GameException {
        correctAnswer = inputNumber.getInputNumber();
    }

    public BaseballGameStatus play(InputNumber userExpectedInputMessage) throws GameException {
        GameGroupsCompareResult gameGroupsCompareResult = GameNumberGroupsHelper.compareEachGameGroup(correctAnswer, userExpectedInputMessage.getInputNumber());
        int strikeScore = gameGroupsCompareResult.getNumberAndDigitSameScore();
        int ballScore = gameGroupsCompareResult.getNumberSameScore();

        if (strikeScore == GameNumberGroups.MESSAGE_ALLOW_LENGTH_MAX) {
            return BaseballGameStatus.WIN;
        }

        if (strikeScore + ballScore > 0) {
            return BaseballGameStatus.RETRY;
        }

        return BaseballGameStatus.NOTING;
    }
}
