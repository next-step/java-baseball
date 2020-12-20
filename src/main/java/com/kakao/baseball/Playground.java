package com.kakao.baseball;

import com.kakao.baseball.game.BaseballGame;

import java.util.Scanner;

public class Playground {
    private BaseballGame baseballGame;
    private Scanner sc;
    public Playground(){
        baseballGame = new BaseballGame();
        sc = new Scanner(System.in);
    }

    public void run(){
        int input;
        while(true){
            System.out.print("숫자를 입력해 주세요 : ");
            input = sc.nextInt();
            if(!baseballGame.validateInput(input)){
                System.out.println("잘못된 입력입니다 다시 입력해주세요.");
                continue;
            }
            baseballGame.checkUserInput(input);
            System.out.println(baseballGame.getResult());
            if(isEnd()){
                break;
            }
        }
    }
    private boolean isEnd(){
        if(baseballGame.isWin()) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input = sc.nextInt();
            if (input == 1) {
                baseballGame.initBaseballNumber();
                return false;
            }
            return true;
        }
        return false;
    }
}
