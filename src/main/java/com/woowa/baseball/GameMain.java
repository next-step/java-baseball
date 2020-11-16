package com.woowa.baseball;

public class GameMain {

    public static void main(String[] args) {
        GameHandler gameHandler = new GameHandler();
        String isContinue = "1";
        while (isContinue.equals("1")) {
            isContinue = gameHandler.playGame();
        }
    }
}
