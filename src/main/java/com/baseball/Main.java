package com.baseball;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer randomNumber;
        Game game = new Game();
        do {
            randomNumber = game.randomNumber();     // 1~9 사이의 서로 다른 세자리 숫자를 랜덤으로 만든다.
            playGame(game);                         // 게임을 플레이한다.
        } while (isMoreGame());                 // 게임을 다시 시작하거나 완전히 종료한다.
    }

    /**
     * 게임을 새로 시작할지 종료할지 사용자에게 물어보는 기능
     * @return true: 게임 새로 시작, false: 종료
     */
    private static boolean isMoreGame() {
        Scanner sc = new Scanner(System.in);

        Integer answer;
        do {
            System.out.println("게임을 새로 시작하려면 1,종료하려면 2를 입력하세요.");
            answer = sc.nextInt();
        } while (answer != 1 && answer != 2);

        if (answer == 1)
            return true;
        return false;
    }

    private static void playGame(Game game) {
        Integer inputNumber;
        Integer strike;
        Integer ball;
        do {
            inputNumber = inputNumber();                    // 세자리 숫자를 입력받는다.
            strike = game.countStrike(inputNumber);
            ball = game.countBall(inputNumber);
            showHintNumber(strike, ball);                   // 사용자에게 힌트를 보여준다.
        } while(strike != 3);   // 3 스트라이크이면 게임을 종료한다.
    }

    private static Integer inputNumber() {
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요: ");
        Integer answer = sc.nextInt();

        return answer;
    }

    private static void showHintNumber(Integer strike, Integer ball) {

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike > 0 && ball > 0) {
            System.out.println(strike.toString() + " 스트라이크 " + ball.toString() + " 볼");
            return;
        }

        if (strike > 0) {
            System.out.println(strike.toString() + " 스트라이크 ");
            return;
        }

        if (ball > 0) {
            System.out.println(ball.toString() + " 볼");
            return;
        }
    }

}
