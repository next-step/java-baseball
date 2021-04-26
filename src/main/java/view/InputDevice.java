package view;

import baseball.BaseballNumber;
import baseball.enumerator.GameProgress;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputDevice {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputNumber() {
        String answerEntered = SCANNER.nextLine().trim();
        checkInputValidationLength(answerEntered);
        checkInputValidationValue(answerEntered);
        return Integer.parseInt(answerEntered);
    }

    private static void checkInputValidationLength(String answerEntered){
        if(answerEntered.length() != 3){
            throw new IllegalArgumentException("3 자리 숫자만 입력 가능합니다.");
        }
    }
    private static void checkInputValidationValue(String answerEntered){
        try{
            Integer.parseInt(answerEntered);
        }catch (NumberFormatException numberFormatException){
            numberFormatException.printStackTrace();
            throw new NumberFormatException("숫자만 입력 가능합니다.");
        }
    }

    public void checkProcessCodeRange(int processCode) {
        if (GameProgress.RESTART.getValue() == processCode || processCode == GameProgress.EXIT.getValue()) {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

}
