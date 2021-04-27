package com.baseball;

import com.baseball.domain.baseballgame.BaseballGame;
import com.baseball.util.Util;

public class EntryPoint {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        while (true) {
            baseballGame.play();
            if (baseballGame.isStop()) {
                break;
            }
        }
    }

}
