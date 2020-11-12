package com.game.common;

public interface Game {

    void start();
    void restart();
    void exit();
    boolean isValidInput(String input);
}
