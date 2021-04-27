package kr.aterilio.nextstep.techcamp.precourse.baseball;

import kr.aterilio.nextstep.techcamp.precourse.baseball.ui.InputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start(inputView);
        } while(inputView.isNewGame());
    }
}
