package com.wootechcamp.precourse.baseball;

import java.util.Random;

public class BaseBallGame {

    public void gameStart() {
        System.out.println("start!");

        int answer = getRandomNumber();
        System.out.println("random :" + answer);
    }

    public int getRandomNumber() {
        Random random = new Random();
        int low = 100;
        int high = 1000;

        int result = random.nextInt(high-low) + low;

        return result;
    }
}

