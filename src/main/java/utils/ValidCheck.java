package utils;

import java.util.HashSet;
import java.util.regex.Pattern;

public class ValidCheck {

    // 숫자(모든 자리수가 1~9) 여부
    public static boolean isNumeric(String str) {
        return Pattern.matches("^[1-9]*", str);
    }

    // size 체크
    public static boolean validLength(String str, int size) {
        return Pattern.matches("^\\d{" + size + "}", str);
    }

    // 중복 문자 여부
    public static boolean hasDuplicate(String str) {
        HashSet hashSet = new HashSet<Character>();
        for (char c : str.toCharArray()) {
            hashSet.add(c);
        }
        return (hashSet.size() != str.length()) ? false : true;
    }
}
