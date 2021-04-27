package com.tech.baseball;

public class Main {

    static BaseballGame game = new BaseballGame();

    public static void main(String[] args) {
        boolean isStartGame = true;

        while(isStartGame){
            isStartGame = game.baseballGameStart();
        }
    }

}
