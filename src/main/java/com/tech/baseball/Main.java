package com.tech.baseball;

import com.tech.baseball.service.BaseballGameService;

public class Main {

    static BaseballGameService game = new BaseballGameService();

    public static void main(String[] args) {
        boolean isStartGame = true;

        while(isStartGame){
            isStartGame = game.baseballGameStart();
        }
    }

}
