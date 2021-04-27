package view;

import baseball.BaseballNumber;
import baseball.enumerator.GameProgress;

import java.util.*;

public class InputDevice {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<BaseballNumber> inputNumber() {
        String answerEntered = SCANNER.nextLine().trim();
        checkInputValidRange(answerEntered);
        checkInputValidValue(answerEntered);
        checkInputValidDuplicate(answerEntered);
        return stringToBaseballNumbers(answerEntered);
    }

    public static void checkInputValidRange(String answerEntered) {
        if (answerEntered.length() != 3) {
            throw new IllegalArgumentException("3 자리 숫자만 입력 가능합니다.");
        }
    }

    public static void checkInputValidValue(String answerEntered) {
        try {
            Integer.parseInt(answerEntered);
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }

    public static void checkInputValidDuplicate(String answerEntered){
        Set<Character> duplicateHelper = new HashSet<>();
        for(int i = 0; i < answerEntered.length(); i++) {
            duplicateHelper.add(answerEntered.charAt(i));
        }
        if(duplicateHelper.size() != answerEntered.length()){
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static List<BaseballNumber> stringToBaseballNumbers(String answerEntered) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for(int i = 0; i < answerEntered.length(); i++) {
            baseballNumbers.add(new BaseballNumber(answerEntered.charAt(i)));
        }
        return baseballNumbers;
    }

    public void checkProcessCodeRange(int processCode) {
        if (GameProgress.RESTART.getValue() == processCode || processCode == GameProgress.EXIT.getValue()) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

}
