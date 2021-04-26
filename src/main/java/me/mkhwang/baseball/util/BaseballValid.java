package me.mkhwang.baseball.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class BaseballValid {

    private static final int BALL_LENGTH = 3;
    private static final char MIN_NUMBER = '1';
    private static final char MAX_NUMBER = '9';

    public boolean isBaseballLengthValid(String ballNumber) {
        return ballNumber.length() == BALL_LENGTH;
    }

    public boolean isBaseballDuplicateValid(String ballNumber) {
        boolean valid = true;
        char[] ballNumberArr = ballNumber.toCharArray();
        for (char validNumber : ballNumberArr) {
            valid = isDuplicateNumber(valid, ballNumber, validNumber);
        }
        return valid;
    }

    private String firstCharIgnore(String ballNumber, char validNumber) {
        String testNum = ballNumber.replaceFirst(String.valueOf(validNumber),"");
        return testNum;
    }

    private boolean isDuplicateNumber(boolean valid, String ballNumber, char validNumber) {
        if(!valid) {
            return false;
        }

        String testNum = firstCharIgnore(ballNumber, validNumber);
        if(testNum.contains(String.valueOf(validNumber))) {
            return false;
        }

        return true;
    }

    public boolean isBaseballTextValid(String text) {
        boolean valid = true;
        char[] textArr = text.toCharArray();
        for (char validNumber : textArr) {
             valid = isValidNumber(valid, validNumber);
        }
        return valid;
    }

    private boolean isValidNumber(boolean valid, char validNumber) {
        if(!valid){
            return false;
        }

        if(validNumber < MIN_NUMBER || validNumber > MAX_NUMBER){
            valid = false;
        }

        return valid;
    }

}
