/*
 * BaseballGame.java
 * version : 1.0
 * Date : 2020 / 12 / 30
 * Author : pavlo.v
 */
package com.pavlo.baseball;

import java.util.Scanner;

public class BaseballGame {

    private static final int NUM_LENGTH = 3;
    private static final int NUM_RANGE = 9;
    private static final Scanner scanner = new Scanner(System.in);

    private String computerString;
    private String playerString;
    private boolean isAnswer = false;

    public void start() {
        do {
            computerString = makeComputerNumString();
            isAnswer = false;
            process();
        } while (againGame());
    }

    /* 컴퓨터의 3자리 난수값과 사용자의 값을 비교하여 적절한 msg 를 만들어내는 함수 */
    private String makeMsg() {
        if (isInvalidInput(playerString)) {
            return "사용자 입력값이 잘못 되었습니다.";
        }

        StringBuilder msg = new StringBuilder();

        int strike = getStrikeCount(computerString, playerString);
        int ball = getBallCount(computerString, playerString);

        if (strike > 0) {
            msg.append(strike).append(" 스트라이크 ");
        }
        if (ball > 0) {
            msg.append(ball).append(" 볼");
        }
        if (strike == 0 && ball == 0) {
            msg.append("낫싱");
        }


        return msg.toString();
    }

    /* 두개의 문자열 값으로 볼의 개수를 반환하는 함수 */
    private int getBallCount(String computerString, String playerString){
        return 1;
    }

    /* 두개의 문자열 값으로 스트라이크의 개수를 반환하는 함수 */
    private int getStrikeCount(String computerString, String playerString) {
        return 1;
    }

    /* 게임이 끝난후 다시할건지 묻는 함수 */
    private boolean againGame() {
        System.out.print("다시 게임을 하시려면 1, 종료하시려면 2를 입력하시요");
        String type = scanner.nextLine();
        return type.equals("1");
    }

    /* 게임이 진행되는 경우 사용자 입력값을 받는 함수 */
    private void process() {
        do {
            System.out.print("숫자를 입력해주세요 : ");
            playerString = scanner.nextLine();
            String msg = makeMsg();
            System.out.println(msg);
        } while (isAnswer);
    }


    /* 세자리의 난수를 생성하기 위한 함수*/
    public String makeComputerNumString() {
        StringBuilder numString = new StringBuilder();

        while (numString.length() < NUM_LENGTH) {
            int num = getRandomNumber(numString.toString());
            numString.append(num);
        }

        return numString.toString();
    }


    /* 중복되지 않는 난수값을 얻기 위한 함수 */
    private int getRandomNumber(String numString) {
        int n = -1;

        do {
            n = (int) (Math.random() * NUM_RANGE) + 1;
        } while (numString.contains(Integer.toString(n)));

        return n;
    }

    /* 사용자의 입력 값을 확인하기 위한 함수 */
    private boolean isInvalidInput(String playerString) {
        if (playerString.contains("0") || playerString.length() != NUM_LENGTH) {
            return true;
        }
        try {
            Integer.parseInt(playerString);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
