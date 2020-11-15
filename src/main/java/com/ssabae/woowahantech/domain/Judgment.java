package com.ssabae.woowahantech.domain;

import com.ssabae.woowahantech.Constant;
import com.ssabae.woowahantech.domain.baseballnumber.BaseballNumbers;

import java.util.List;

/**
 * @author : leesangbae
 * @project : java-baseball
 * @since : 2020-11-15
 */
public class Judgment {

    public boolean isCorrect(BaseballNumbers gameNumber, BaseballNumbers userInputNumber) {
        if (userInputNumber == null) {
            return false;
        }
        List<Integer> gameNumberList = gameNumber.getBaseballNumberList();
        List<Integer> userInputNumberList = userInputNumber.getBaseballNumberList();

        GameScore gameScore = getGameScore(gameNumberList, userInputNumberList);
        gameScore.print();

        return gameScore.isCorrect();
    }

    private GameScore getGameScore(List<Integer> gameNumberList, List<Integer> userInputNumberList) {
        GameScore score = new GameScore();
        for (int i = 0; i < Constant.GAME_NUMBER_SIZE; i++) {
            setGameScore(score, gameNumberList, userInputNumberList, i);
        }
        return score;
    }

    private void setGameScore(GameScore score, List<Integer> gameNumberList, List<Integer> userInputNumberList, int index) {
        if (gameNumberList.get(index).equals(userInputNumberList.get(index))) {
            score.addStrike();
            return;
        }
        if (gameNumberList.contains(userInputNumberList.get(index))) {
            score.addBall();
        }
    }
}
