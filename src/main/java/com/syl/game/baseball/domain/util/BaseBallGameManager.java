package com.syl.game.baseball.domain.util;

import com.syl.game.baseball.domain.player.dto.InputNumbers;
import com.syl.game.baseball.domain.util.dto.BaseBallJudgementStatus;

public class BaseBallGameManager {

    private static BaseBallGameManager instance;
    private static String currentPlayer;

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
     * @param inputNumbers
     * @return 판정 상태값
     */
    public BaseBallJudgementStatus judgeStrikeOrBallOrNothing(InputNumbers inputNumbers) {
        BaseBallJudgementStatus baseBallJudgementStatus = new BaseBallJudgementStatus();
        return baseBallJudgementStatus;
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
