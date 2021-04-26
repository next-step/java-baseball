package com.game.ui;

public class PrintMessage {

    public void printExitMessage() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. :");
    }

    public void printResultMessage(int strike, int ball) {
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return;
        }
        if(strike == 0 && ball ==0){
            System.out.println("낫싱");
            return;
        }
        printResultTypeMessage(strike,ball);
    }

    public void printResultTypeMessage(int strike, int ball) {
        if(strike == -1 || ball == -1){
            return;
        }
        System.out.println(strike + "스트라이크 "+ball+"볼 ");
    }

}
