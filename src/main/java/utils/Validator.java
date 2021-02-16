package utils;

import domain.BaseballNumber;
import domain.BaseballNumberBundle;

import java.util.Arrays;
import java.util.HashSet;

public class Validator {
    private Validator() {}

    public static void oneToNineNumberValidation(int number){
        if(number < BaseballNumber.MINIMUM_BASEBALL_NUMBER || number > BaseballNumber.MAXIMUM_BASEBALL_NUMBER){
            throw new IllegalArgumentException("1~9의 숫자만 입력할 수 있습니다.");
        }
    }

    public static void threeLengthNumberValidation(int number){
        if(String.valueOf(number).length() != BaseballNumberBundle.BUNDLE_LENGTH){
            throw new IllegalArgumentException("3자리의 수를 입력해야 합니다.");
        }
    }

    public static void duplicatedThreeNumberValidation(int number){
        String[] splitStringNumbers = String.valueOf(number).split("");
        int uniqueNumberSize = new HashSet<>(Arrays.asList(splitStringNumbers)).size();
        if (uniqueNumberSize != BaseballNumberBundle.BUNDLE_LENGTH){
            throw new IllegalArgumentException("중복된 숫자를 입력하면 안됩니다.");
        }
    }
}
