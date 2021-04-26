package me.nimkoes.baseball.util;

import java.util.HashSet;
import java.util.Set;

import me.nimkoes.baseball.MainLauncher;
import me.nimkoes.baseball.view.Message;

public class Validation {
    /*
     * 입력 값이 숫자로만 이루어졌는지 검사
     */
    public static boolean isNumberData(String number) {
        boolean checkResult = number.matches("^[0-9]+$");
        if(!checkResult) {
            System.out.println(Message.INVALID_FORMAT.getMsg());
        }
        return checkResult;
    }

    /*
     * 두 수의 길이가 같은지 검사
     */
    public static boolean isCorrectLength(String number, int numberSize) {
        boolean checkResult = number.length() == numberSize;
        if(!checkResult) {
            System.out.println(MainLauncher.LENGTH_OF_NUMBER + Message.INVALID_LENGTH.getMsg());
        }
        return checkResult;
    }

    /*
     * 입력 값 중에 중복되는 숫자가 존재하는지 검사
     */
    public static boolean isContainDuplicateNumber(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            characterSet.add(c);
        }

        boolean checkResult = input.length() != characterSet.size();
        if(checkResult) {
            System.out.println(Message.INVALID_DUPLICATE_NUMBER.getMsg());
        }
        return checkResult;
    }

    /*
     * 새 게임을 시작할지 판단하기 위한 값으로 유효한 값을 입력했는지 검사
     */
    public static boolean checkEndingValue(String input) {
        if (!isNumberData(input)) {
            return false;
        }
        if ("1".equals(input) || "2".equals(input)) {
            return true;
        }

        System.out.println(Message.INVALID_ENDING_VALUE.getMsg());
        return false;
    }

}
