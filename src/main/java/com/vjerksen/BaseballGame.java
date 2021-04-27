package com.vjerksen;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {

    InputNumber inputNumber = new InputNumber();
    RandomNumber randomNumber = new RandomNumber();
    final int STRIKE_NUM = 3;
    String randomNum, inputNum;

    public boolean playGame() {
        randomNum = randomNumber.generateNumber();
        boolean endFlag = false;

        while(endFlag == false) {
            System.out.print("숫자를 입력해주세요 : ");
            inputNum = inputNumber.generateNumber();
            endFlag = chkCondition(randomNum, inputNum);
        }

        askEnd();

        if(chkContinue() == true) {
            return playGame();
        }

        return true;

    }

    public boolean chkCondition(String compValue1, String compValue2) {
        int[] chkArray = {0, 0};
        Set<Character> set = new HashSet<>();

        for(int i=0;i<compValue1.length();i++) {
            chkArray[0] += compareToStirke(compValue1.charAt(i), compValue2.charAt(i));
        }

        for(int i=0;i<compValue1.length();i++) {
            set.add(compValue1.charAt(i));
        }

        for(int i=0;i<compValue2.length();i++) {
            chkArray[1] += compareToBall(set, compValue2.charAt(i));
        }

        printCondition(chkArray[0], chkArray[1] - chkArray[0]);

        if(chkArray[0] == 3) {
            return true;
        }

        return false;

    }

    public int compareToStirke(char compValue1, char compValue2) {
        if(compValue1 == compValue2) {
            return 1;
        }
        return 0;
    }

    public int compareToBall(Set<Character> set, char compValue2) {
        if(set.contains(compValue2)) {
            return 1;
        }
        return 0;
    }

    public void printCondition(int numOfStrike, int numOfBall) {
        if(numOfStrike == 0 && numOfBall == 0) {
            System.out.println("낫싱");
        }

        if(numOfStrike != 0 && numOfBall == 0) {
            System.out.println(Integer.toString(numOfStrike) + " 스트라이크");
        }

        if(numOfStrike == 0 && numOfBall != 0) {
            System.out.println(Integer.toString(numOfBall) + " 볼");
        }

        if(numOfStrike != 0 && numOfBall != 0) {
            System.out.println(Integer.toString(numOfStrike) + " 스트라이크" + Integer.toString(numOfBall) + " 볼");
        }

    }

    public void askEnd() {
        System.out.println(Integer.toString(STRIKE_NUM) + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public boolean chkContinue() {
        Scanner sc = new Scanner(System.in);
        if(sc.nextInt() == 1) {
            return true;
        }
        return false;
    }

}
