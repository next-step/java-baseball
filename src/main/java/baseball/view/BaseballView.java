package baseball.view;

import baseball.model.InningsResult;

public interface BaseballView {
    void printStartInnings();
    String inputOneInnings();
    void printInningsResult(InningsResult inningsResult);
    void printFinishInnings();
    boolean inputIsFinishGame();
}