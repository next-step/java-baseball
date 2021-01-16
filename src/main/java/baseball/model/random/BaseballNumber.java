package baseball.model.random;

import baseball.model.InningsResult;

public interface BaseballNumber {
    void makeRandomAnswer();
    InningsResult solveAnswer(String oneInnings);
}