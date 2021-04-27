package com.tech.baseball.validator;

import java.util.HashSet;

public class BaseballGameValidator {

    //valid check
    public boolean checkNumberValid(String input) {
        if(input.length() != 3) return false;
        String regExp = "^[1-9]+$";

        if(!input.matches(regExp)) return false;

        return !checkDuplicate(input);
    }

    public boolean checkDuplicate(String input) {
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < input.length(); i++){
            if(set.contains(input.charAt(i))) return true;
            set.add(input.charAt(i));
        }

        return false;
    }

    public boolean checkRestartValid(String input) {
        return input.equals("1")||input.equals("2");
    }

}
