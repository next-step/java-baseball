package com.tistory.javapanda.baseball;

import com.tistory.javapanda.baseball.service.BaseBallService;
import com.tistory.javapanda.baseball.util.RandomGenerator;
import com.tistory.javapanda.baseball.view.BaseBallView;
import com.tistory.javapanda.baseball.vo.BaseBallVo;

import java.util.List;

public class BaseBallManager {

    BaseBallService baseBallService;
    BaseBallView baseBallView;

    public BaseBallManager(BaseBallService baseBallService, BaseBallView baseBallView) {
        this.baseBallService = baseBallService;
        this.baseBallView = baseBallView;
    }

    public void start() {
        boolean isPlay = true;
        do {
            List<Integer> inputNumbers = init();
            BaseBallVo baseBallVo = baseBallService.play(inputNumbers);
            baseBallView.resultMessage(baseBallVo);
            if (baseBallVo.getStrike() == 3) {
                isPlay = isRestart();
            }
        } while (isPlay);
    }

    public List<Integer> init() {
        baseBallView.inputNumbersMessage();
        return baseBallService.validateInputNumbers();
    }

    public boolean isRestart() {
        baseBallView.finishMessage();
        int number = baseBallService.getScanner().nextInt();
        if (number == 2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BaseBallService baseBallService = new BaseBallService(RandomGenerator.getNumbers());
        BaseBallView baseBallView = new BaseBallView();
        BaseBallManager baseBallManager = new BaseBallManager(baseBallService, baseBallView);
        baseBallManager.start();
    }
}
