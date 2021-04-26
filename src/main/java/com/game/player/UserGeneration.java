package com.game.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserGeneration implements GenerationUtil {

    @Override
    public List<String> getTargetNumber() {
        return checkTargetNumber();
    }

    public List<String> checkTargetNumber() {
        List<String> resultList = new ArrayList<>();
        try {
            resultList = divideNumber(getUserInputNumber());
        } catch (Exception e) {
            resultList.clear();
            System.out.println(e.getMessage());
        }
        return resultList;
    }

    private List<String> divideNumber(String userInputNum) {
        List<String> numberList = new ArrayList<>();
        int idx = 0;
        while (idx < 3 && checkNumValue(userInputNum, idx)){
            changeToArray(Character.toString(userInputNum.charAt(idx)), numberList);
            numberList.add(Character.toString(userInputNum.charAt(idx)));
            idx++;
        }
        return numberList;
    }

    private void changeToArray(String userInputNum, List numberList) {
        if(checkDuplication(userInputNum, numberList)) {
            throw new IllegalArgumentException("중복된 숫자는 불가합니다.");
        }
    }

    private String getUserInputNumber() {
        System.out.print("숫자를 입력하세요 :");
        Scanner scanner = new Scanner(System.in);
        String  inputNumber = scanner.nextLine();
        return inputNumber;
    }

    private boolean checkNumValue(String inputNumber, int idx) {
        if(!Character.isDigit(inputNumber.charAt(idx)) || "".equals(Character.toString(inputNumber.charAt(idx)))) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
        if(inputNumber.length() !=3) {
            throw new NumberFormatException("3자리 숫자를 입력해주세요.");
        }
        return true;
    }

    private boolean checkDuplication (String targetNumber, List numberList){
        return numberList.contains(targetNumber);
    }

}
