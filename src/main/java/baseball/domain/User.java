package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class User {

    private final static int CREATE_SIZE = 3;

    public static ArrayList<Integer> inputStrToList(String numbersStr) throws IllegalArgumentException {
        Set<Integer> numbers = new LinkedHashSet<>();
        validateSize(numbersStr);
        for(int i=0; i<CREATE_SIZE; i++) {
            validateNumber(numbersStr.charAt(i));
            numbers.add(Integer.parseInt(String.valueOf(numbersStr.charAt(i))));
        }
        validateDiffNumber(numbers);
        return new ArrayList<>(numbers);
    }

    public static void validateRestart(String str) throws IllegalArgumentException {
        if(!("1".equals(str) || "2".equals(str))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세여");
        }
    }

    private static void validateSize(String numbersStr) throws IllegalArgumentException {
        if(numbersStr.length() != CREATE_SIZE) {
            throw new IllegalArgumentException("숫자1~9인 3자리 수 를 입력하세요.");
        }
    }

    private static void validateNumber(char ch) throws IllegalArgumentException {
        if(!(ch >= '1' && ch <= '9')) {
            throw new IllegalArgumentException("숫자1~9만 입력하세요.");
        }
    }

    private static void validateDiffNumber(Set<Integer> numbers) throws IllegalArgumentException {
        if(numbers.size() < 3) {
            throw new IllegalArgumentException("서로 다른 수 를 입력하세요.");
        }
    }
}
