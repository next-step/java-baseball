package com.baseballgame.util;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    private List<String> changeArrayList;

    public List<String> changeStringToArray(String inputNumber) {
        changeArrayList = new ArrayList<String>();
        String target = inputNumber.trim();
        for(int i = 0 ; i < target.length(); i++){
            checkNumber(target.charAt(i));
        }
        return changeArrayList;
    }

    public void checkNumber(char number) {
        if(Character.isDigit(number) == false || changeArrayList.contains(String.valueOf(number)) == true) {
            return;
        }
        changeArrayList.add(String.valueOf(number));
        return;
    }
}
