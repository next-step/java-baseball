package com.nextstep.ppyong.utils;

public class RandomNumberUtil {
    private final static int RANDOM_MIN_NUMBER = 1;
    private final static int RANDOM_MAX_NUMBER = 9;
    private int numberLength;

    public RandomNumberUtil (int numberLength) {
        this.numberLength = numberLength;
    }

    public String createRandomNumber() {
        StringBuilder appender = new StringBuilder();
        boolean isContinue = true;
        while(isContinue) {
            int randomNumber = (int) (Math.random() * (RANDOM_MAX_NUMBER - RANDOM_MIN_NUMBER + 1) + RANDOM_MIN_NUMBER);
            isContinue = checkCondition(appender, randomNumber);
        }
        //System.out.println(String.format("[createRandomNumber] result: %s", appender.toString()));
        return appender.toString();
    }

    private boolean checkCondition(StringBuilder sb, int randomNum) {
        if(sb.indexOf(String.valueOf(randomNum)) == -1) {
            sb.append(randomNum);
        }
        if(sb.length() >= numberLength) {
            return false;
        }
        return true;
    }
}
