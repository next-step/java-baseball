package com.baseball;

public class Main {
    public static void main(String[] args) {
        Integer randomNumber;
        do {
            randomNumber = randomNumber();     // 1~9 사이의 서로 다른 세자리 숫자를 랜덤으로 만든다.
            playGame(randomNumber);             // 게임을 플레이한다.
        } while (isMoreGame());                 // 게임을 다시 시작하거나 완전히 종료한다.
    }


    private static Integer randomNumber() {
        return 123;
    }

    private static boolean isMoreGame() {
        return false;
    }

    private static void playGame(Integer randomNumber) {
        Integer inputNumber;
        do {
            inputNumber = inputNumber();                    // 세자리 숫자를 입력받는다.
        } while(! hintNumber(randomNumber, inputNumber));   // 힌트를 제공하고 3 스트라이크이면 게임을 종료한다.
    }

    private static Integer inputNumber() {
        return 123;
    }

    private static Boolean hintNumber(Integer randomNumber, Integer inputNumber) {
        return true;
    }

}
