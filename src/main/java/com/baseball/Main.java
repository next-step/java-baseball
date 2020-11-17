package com.baseball;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            playGame(new Game());      // 1~9 사이의 서로 다른 세자리 숫자를 랜덤으로 만들고 게임을 플레이한다.
        } while (isMoreGame());        // 게임을 다시 시작하거나 완전히 종료한다.
    }


    private static void playGame(Game game) {
        do {
            inputNumber(game);                    // 세자리 숫자를 입력받는다.
            showHintNumber(game.getStrike(), game.getBall());   // 사용자에게 힌트를 보여준다.
        } while(game.getStrike() != 3);                         // 3 스트라이크이면 게임을 종료한다.
    }


    /**
     * 게임을 새로 시작할지 종료할지 사용자에게 물어본다
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


    /**
     * 사용자가 추측하는 세자리 숫자를 입력받는다.
     * @return
     */
    private static Integer inputNumber(Game game) {
        Scanner sc = new Scanner(System.in);

        Integer inputNumber = 0;
        do {
            System.out.print("숫자를 입력해주세요: ");
            inputNumber = sc.nextInt();
            game.inputNumber(inputNumber);
        } while (! validateNumber(game));
        return inputNumber;
    }

    /**
     * 사용자가 입력한 숫자의 유효성을 체크하여 잘못된 값을 입력했을 경우
     * 해당 메세지를 보여준다.
     * @param game
     * @return
     */
    private static Boolean validateNumber(Game game) {
        if (! game.isThreeNumber()) {
            System.out.println("세자리 숫자로 입력하세요.");
            return false;
        }

        if (! game.isDifferentNumber()) {
            System.out.println("각자리의 숫자는 서로 달라야 합니다.");
            return false;
        }

        return true;
    }


    /**
     * 사용자에게 힌트를 보여준다.
     * @param strike    스트라이크 갯수
     * @param ball      볼 갯수
     */
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
