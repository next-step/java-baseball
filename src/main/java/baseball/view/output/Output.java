package baseball.view.output;

import baseball.domain.BaseballResult;

public interface Output {
    void print(final String message);

    void printValiedateNumber(int numberSize);

    void printEndMessage();

    void printResult(BaseballResult result);
}
