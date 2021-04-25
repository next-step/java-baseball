package com.baseball.precourse.baseball;

public class Game {

    private UserInput userInput;

    public Game(UserInput userInput){
        this.userInput = userInput;
    }

    public void play(){
        Score score;
        Player player = new Player();
        do{
            Ball ball = chooseBall();
            score = player.hit(ball);
            System.out.println(score);
        } while(!score.isOut());
    }

    public boolean isOver(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String command = userInput.readInput();
        if (command.equals("2")){
            return true;
        }
        return false;
    }

    public Ball chooseBall(){
        String command = "";
        do {
            System.out.print("숫자를 입력해주세요 : ");
            command = userInput.readInput();
        } while(command.length() != 3);
        return new Ball(command);
    }
}
