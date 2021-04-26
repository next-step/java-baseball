package view;

import domain.BaseballResult;

public class ResultView {

    private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";

    public void showResult(BaseballResult result) {
        System.out.println(result.resultScreen());
    }

    public void finishScreen() {
        System.out.println(FINISH_MESSAGE);
    }
}
