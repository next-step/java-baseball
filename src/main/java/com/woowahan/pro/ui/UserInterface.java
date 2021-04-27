package com.woowahan.pro.ui;

public interface UserInterface {
    String[] requireNumbers();

    void outputOnFinishGame();

    String inputRetry();

    void outputScore(int strike, int ball);

    void close();
}
