package com.syl.game.baseball.domain.util;

import com.syl.game.baseball.domain.entity.BaseBallJudgementStatus;
import com.syl.game.baseball.domain.entity.BaseBallNumbers;

public class BaseBallGameManager {

    private String currentPlayer;
    private static BaseBallGameManager instance;

    public static BaseBallGameManager getInstance() {
        synchronized (BaseBallGameManager.class) {
            if (instance == null) {
                instance = new BaseBallGameManager();
            }
            return instance;
        }
    }

    /**
     * 스트라이크, 볼, 포볼을 판단한다.
     * @param selectedNumbers
     * @param inputNumbers
     * @return 판정 상태값
     */
    public BaseBallJudgementStatus judgeStrikeOrBallOrNothing(BaseBallNumbers selectedNumbers, BaseBallNumbers inputNumbers) {
        int strike = selectedNumbers.countStrike(inputNumbers);
        int ball = selectedNumbers.countBall(inputNumbers);
        int nothing = selectedNumbers.countNothing(inputNumbers);
        return new BaseBallJudgementStatus(strike, ball, nothing);
    }

    /**
     * 현재 플레이어를 가져온다.
     * @return 현재 플레이어
     */
    public String getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * 현재 플레이어를 세팅한다.
     * @param playerName
     */
    public void setCurrentPlayer(String playerName) {
        currentPlayer = playerName;
    }


}
