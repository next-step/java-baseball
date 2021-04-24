package baseball.view;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInputView {

    private final static int CREATE_SIZE = 3;

    public static Set<Integer> inputNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("숫자를 입력해 주세요 : ");
            numbers = inputStrToSet(sc.nextLine());
        } catch (IllegalArgumentException e) {
            numbers = inputNumbers();
        }
        return numbers;
    }

    private static Set<Integer> inputStrToSet(String numbersStr) throws IllegalArgumentException {
        Set<Integer> numbers = new LinkedHashSet<>();
        validateSize(numbersStr);
        for(int i=0; i<CREATE_SIZE; i++) {
            validateNumber(numbersStr.charAt(i));
            numbers.add(Integer.parseInt(String.valueOf(numbersStr.charAt(i))));
        }
        validateDiffNumber(numbers);
        return numbers;
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
