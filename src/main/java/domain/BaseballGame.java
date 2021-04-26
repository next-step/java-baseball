package domain;

import common.Const;
import util.InputValidators;
import util.RandomNumberGenerator;
import view.ViewLayer;

import java.util.*;

public class BaseballGame {

    private ViewLayer viewLayer = new ViewLayer();

    public void init() {
        do {
            start();
        } while (restart());
    }

    public void start() {

        List<Integer> randomNumbers = RandomNumberGenerator.makeBaseballNumber();

        boolean playStatus = true;

        while (playStatus) {
            viewLayer.outValue("3자리 숫자 입력: ");
            String inputValue = viewLayer.inputValue();

            BaseballPlay baseballPlay = new BaseballPlay(randomNumbers);
            List<Integer> inputNumbers = new InputValidators(inputValue).convert();

            baseballPlay.play(inputNumbers);

            BaseballResultMessage baseballResultMessage = new BaseballResultMessage(baseballPlay.getStrikeCount(), baseballPlay.getBallCount());

            viewLayer.outValue(baseballResultMessage.getResultMessage().toString());

            playStatus = baseballResultMessage.getStrikeCount();
        }
    }

    private boolean restart() {
        viewLayer.outValue("3개의 숫자를 모두 맞히셨습니다! 게임종료. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return Const.RESTART_FLAG.equals(viewLayer.inputValue());
    }
}
