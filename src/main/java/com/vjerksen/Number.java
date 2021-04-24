package com.vjerksen;

import java.lang.Math.*;

public class Number {

    public String getRandomNumber() {
        int randNum = 0;
        int idx = 0;
        String randStringNum = "";

        for (int i = 0; i < 3; i++) {
            randNum = (int) (((Math.random() * 10) % 9) + 1);
            randStringNum = randStringNum + Integer.toString(randNum);
        }

        return randStringNum;
    }
}
