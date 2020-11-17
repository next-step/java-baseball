package service;

import interfaces.Game;

import java.io.BufferedInputStream;
import java.io.IOException;

public class GameImplement implements Game {


    @Override
    public void play() throws IOException {

        ComputerImplement computer = new ComputerImplement();
        //computer가 숫자 3개를 고른다.
        computer.selectGameBall();

        while(doGame(computer)){

        }



    }

    public boolean doGame(ComputerImplement computer) throws IOException {
        System.out.println("숫자를 입력해주세요 : ");
        PlayerImplement player = new PlayerImplement();
        player.inputGuessableNumber();
        computer.guessNumberResult(player.getInputNum());
        printResult(computer.getStrikeCnt(),computer.getBallCnt());
        if(computer.getStrikeCnt() == 3){
            return false;
        }
        return true;
    }

    public boolean reGame(int inputNum){
        if(inputNum == 1){
            return true;
        }
        return false;
    }

    public void printResult(int strikeCnt,int ballCnt){


        if(strikeCnt > 0 && ballCnt>0){
            System.out.println(strikeCnt+"스트라이크 "+ballCnt+"볼");
        }
        if(strikeCnt>0 && ballCnt ==0){
            System.out.println(strikeCnt+"스트라이크 ");
        }
        if(strikeCnt==0 && ballCnt > 0){
            System.out.println(ballCnt+"볼");
        }
        if(strikeCnt==0 && ballCnt == 0){
            System.out.println("낫싱");
        }
        if(strikeCnt ==3){
            System.out.println(strikeCnt+"개의 숫자를 모두 맞히셨습니다.게임종료\n게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
        }
    }
    @Override
    public boolean playGameAgain() {
        return false;
    }
}
