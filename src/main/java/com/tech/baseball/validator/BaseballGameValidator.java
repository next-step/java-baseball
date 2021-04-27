package com.tech.baseball.validator;

public class BaseballGameValidator {

    //valid check
    public boolean checkNumberValid(String input) {
        if(input.length() != 3) return false;
        String regExp = "^[1-9]+$";

        return input.matches(regExp);
    }

    public boolean checkRestartValid(String input) {
        return input.equals("1")||input.equals("2");
    }

}
