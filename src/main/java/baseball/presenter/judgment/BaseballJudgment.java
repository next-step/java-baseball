package baseball.presenter.judgment;

import baseball.model.InningsResult;

public interface BaseballJudgment {
    void playNewGame();
    void putInningsResult(String oneInnings); //1이닝이 들어오면, 결과를 돌려주는 함수입니다.
    InningsResult getCurrentInnings();
    boolean isContinueGame();
    void nextMatch(boolean isFinishGame);
}