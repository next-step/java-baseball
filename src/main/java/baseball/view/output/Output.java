package baseball.view.output;

import baseball.domain.BaseballResult;

public interface Output {
    void print(final String message);

    void printValiedateNumber();

    void printEndMessage();

    void printResult(final BaseballResult result);
}
