package com.dnswkdl.main;

import com.dnswkdl.app.GamePlay;

public class Main {
    public static void main(String[] args) {

        GamePlay gamePlay = new GamePlay();
        do{
            gamePlay.init();
            gamePlay.start();
        }while(gamePlay.replay());

    }
}
