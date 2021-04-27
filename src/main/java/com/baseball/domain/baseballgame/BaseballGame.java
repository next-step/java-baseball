package com.baseball.domain.baseballgame;

import com.baseball.domain.baseballnumber.BaseBallNumberInputGenerator;
import com.baseball.domain.baseballnumber.BaseballNumberRandomGenerator;
import com.baseball.domain.computer.Computer;
import com.baseball.domain.judgement.Judgement;
import com.baseball.domain.player.Player;
import com.baseball.util.Util;
import com.baseball.view.Message;

import java.util.List;

public class BaseballGame {

    public static final int RESTART = 1;
    public static final int STOP = 2;

    private Computer computer;
    private Player player;
    private Judgement judgement;

    public void play() {
        computer = new Computer(new BaseballNumberRandomGenerator());

        while(true) {

            List<Integer> input = Util.readPlayerInput();

            player = new Player(new BaseBallNumberInputGenerator(input));
            judgement = player.pitch(computer);

            Message.showJudgementMessage(judgement);

            if (judgement.isAllStrike()) {
                break;
            }
        }
    }

    public boolean isStop() {
        int gameOption = Util.readGameOption();
        if (gameOption == STOP) {
            return true;
        } else if (gameOption == RESTART) {
            return false;
        } else {
            throw new IllegalArgumentException("사용할 수 없는 값 입니다.");
        }
    }

}
