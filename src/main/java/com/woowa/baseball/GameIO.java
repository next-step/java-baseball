package com.woowa.baseball;

import java.util.Scanner;

public class GameIO {

    Scanner sc;

    public GameIO() {
        sc = new Scanner(System.in);
    }

    public void printInputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public void printStrikeBall(int strike, int ball) {
        if (strike > 0) {
            System.out.print(strike + " 스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + " 볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println("");
    }

    public void printEndGame(int strike) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
        }
    }

    public String inputFromUser() {
        String input = sc.next();
        return input;
    }

}
