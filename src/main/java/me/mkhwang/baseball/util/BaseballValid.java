package me.mkhwang.baseball.util;

import me.mkhwang.baseball.type.GameType;

/**
 * Created by mkhwang on 2021/04/25
 * Email : orange2652@gmail.com
 * Github : https://github.com/myeongkwonhwang
 */
public class BaseballValid {

    public boolean isBaseballLengthValid(String ballNumber) {
        return ballNumber.length() == GameType.BALL_LENGTH.getType();
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

    private boolean isValidNumber(boolean valid, int validNumber) {
        char minNumber = numberToChar(GameType.MIN_NUMBER.getType());
        char maxNumber = numberToChar(GameType.MAX_NUMBER.getType());
        if(!valid){
            return false;
        }

        if(validNumber < minNumber || validNumber > maxNumber){
            valid = false;
        }

        return valid;
    }

    private char numberToChar(int number) {
        return Character.forDigit(number, 10);
    }

}
