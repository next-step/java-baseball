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

            gameResult = this.compareBalls();
            this.printGameResult(gameResult.toString());
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
        if (userInput.length() != 3) {
            System.out.println("입력이 길이가 잘못되었습니다. 다시 입력해 주세요");
            return true;
        }

        if (this.checkDuplicateInput(userInput)) {
            System.out.println("중복된 입력이 있습니다. 다시 입력해 주세요");
            return true;
        }

        if (this.isInputIsNumberString(userInput)) {
            System.out.println("1-9까지의 숫자의 입력만 가능합니다. 다시 입력해 주세요");
            return true;
        }

        return false;
    }

    private GameResult compareBalls(){
        gameResult = dealerBall.compareBalls(gamerBall);
        return gameResult;
    }

    private Boolean checkDuplicateInput(String userInput){
        if (userInput.charAt(0) == userInput.charAt(1)) {
            return true;
        }
        if (userInput.charAt(1) == userInput.charAt(2)) {
            return true;
        }
        if (userInput.charAt(0) == userInput.charAt(2)) {
            return true;
        }
        return false;
    }

    private Boolean isInputIsNumberString(String userInput){
        return !userInput.matches("^[1-9]*$");
    }

    private void printGameResult(String gameResultString){
        System.out.println(gameResultString);
    }
}
