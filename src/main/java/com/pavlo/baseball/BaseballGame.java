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
        // 난수를 하나 뽑고 => 저장하고
        StringBuilder numString = new StringBuilder();
        HashSet<Integer> numSet = new HashSet<>();

        while (numSet.size() < NUM_LENGTH) {
            int num = (int) (Math.random() * NUM_RANGE) + 1;
            numSet.add(num);
        }

        for (int n : numSet) {
            numString.append(n);
        }
        return numString.toString();
    }
}
