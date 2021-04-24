package me.nimkoes.baseball.util;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    /*
     * 입력 값이 숫자로만 이루어졌는지 검사
     */
    public static boolean checkNumberData(String number) {
        return number.matches("^[0-9]+$");
    }

    /*
     * 두 수의 길이가 같은지 검사
     */
    public static boolean checkNumberLength(String number, int numberSize) {
        return number.length() == numberSize;
    }

    /*
     * 입력 값 중에 중복되는 숫자가 존재하는지 검사
     */
    public static boolean checkContainDuplicateNumber(String input) {
        Set<Character> characterSet = new HashSet<>();

        for (char c : input.toCharArray()) {
            characterSet.add(c);
        }

        return input.length() != characterSet.size();
    }

    /*
     * 새 게임을 시작할지 판단하기 위한 값으로 유효한 값을 입력했는지 검사
     */
    public static boolean checkEndingValue(String input) {
        if (!checkNumberData(input)) {
            return false;
        }

        if ("1".equals(input) || "2".equals(input)) {
            return true;
        }

        return false;
    }
}
