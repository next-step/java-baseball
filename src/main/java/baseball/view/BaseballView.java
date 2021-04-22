package baseball.view;

import baseball.model.BaseballResult;

public interface BaseballView {
    void printInputPrompt();

    String readInputPrompt();

    void printBaseballResult(BaseballResult baseballResult);

    void printGameResult(BaseballResult baseballResult);

    void printAskingReGame();

}
