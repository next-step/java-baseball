package ui;

import process.GameResult;

public interface Presentator {
    public static final String RESTART = "1";
    public static final String QUIT = "2";

    String presentInputNumber();

    void displayResult(GameResult gameResult);

    String endGame();
}
