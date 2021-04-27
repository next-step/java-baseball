package ui;

import process.GameResult;

public interface Presentator {
    String presentInputNumber();

    void displayResult(GameResult gameResult);
}
