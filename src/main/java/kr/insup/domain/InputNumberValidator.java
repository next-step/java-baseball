package kr.insup.domain;

import java.util.HashSet;
import java.util.Set;

public class InputNumberValidator {

    public static boolean validateNumber(String number) {
        return isNumberMatchRegex(number) && isAllNumberDifferent(number);
    }

    private static boolean isNumberMatchRegex(String number) {
        String regex = "[1-9]{" + GameOptions.HOW_MANY_DIGIT + "}";

        return number.matches(regex);
    }

    private static boolean isAllNumberDifferent(String number) {
        char[] numberArr = number.toCharArray();
        Set<Character> digitCollection = new HashSet<>();
        for (char c : numberArr) {
            digitCollection.add(c);
        }

        return number.length() == digitCollection.size();
    }
}