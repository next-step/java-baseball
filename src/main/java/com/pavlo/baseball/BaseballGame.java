/*
 * BaseballGame.java
 * version : 1.0
 * Date : 2020 / 12 / 30
 * Author : pavlo.v
 */
package com.pavlo.baseball;

import java.util.HashSet;

public class BaseballGame {

    private static final int NUM_LENGTH = 3;
    private static final int NUM_RANGE = 9;

    private String computerString;
    private String playerString;
    private boolean isGameOn = true;

    public void start() {
        computerString = makeComputerNumString();
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
}
