package com.tjnam.baseballgame;

import java.util.Scanner;

public class Game {

    private Balls dealerBall;
    private Balls gamerBall;
    private GameResult gameResult;
    private Scanner scan;

    public Game(){
        this.gamerBall = new Balls();
        this.dealerBall = new Balls();
        this.scan = new Scanner(System.in);
    }

    public void start(){
        do{
            this.run();
        }while(this.checkRestart());
    }

    public void run(){
        gameResult = new GameResult();
        dealerBall.setRandomBalls();
        do {
            System.out.println("숫자를 입력해주세요 : ");
            String userInputBallValue = this.getUserBallInput();
            gamerBall.setBallValues(userInputBallValue);

        } while(this.judgeResult(gameResult));
    }

    public String getUserBallInput(){
        String userInput;
        do {
            userInput = this.scan.nextLine();
        } while(this.isValidUserInput(userInput));
        return userInput;
    }

    private Boolean checkRestart(){
    //TODO : do implement
        return true;
    }

    private Boolean judgeResult(GameResult gameResult){
        //TODO : implements
        return true;
    }

    private Boolean isValidUserInput(String userInput) {
        //TODO : implements
        return false;
    }



}
