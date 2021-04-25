package com.tjnam.baseballgame;

public class Game {

    private Balls dealerBall;
//    private Balls gamerBall;

    public Game(){

    }

    public void start(){
        do{
            this.run();
        }while(this.checkRestart());
    }

    public void run(){
        dealerBall.setRandomBalls();
    }

    private Boolean checkRestart(){
    //TODO : do implement
        return true;
    }



}
