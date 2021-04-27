package com.ascii92der.baseball.ui;

import java.lang.reflect.Member;
import java.util.*;

public class InputUI {

    private Scanner scanner;

    public InputUI() {
        scanner = new Scanner(System.in);
    }

    public String inputNumber() {
        System.out.print(Massage.REQUEST_INPUT_MUNER);
        String result = scanner.nextLine();
        if (!inputNumberValid(result) || duplicateNumber(result)) {
            result = inputNumber();
        }
        return result;
    }

    public String inputCommand() {
        System.out.println(Massage.REQUEST_INPUT_COMMAND);
        String result = scanner.nextLine();
        if (!inputCommandValid(result)) {
            System.out.print(Massage.INVALID_COMMAND);
            result = inputCommand();
        }
        return result;
    }

    private boolean inputNumberValid(String inputString) {
        boolean isValid = true;
        if (inputString.length() != 3 || inputString.contains("0")) {
            isValid = false;
        }
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            isValid = false;
        }
        if (!isValid) {
            System.out.print(Massage.INVALID_INPUT);
        }
        return isValid;
    }

    private boolean duplicateNumber(String inputString) {
        List<String> stringList = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < inputString.length(); i++) {
            stringList.add(inputString.charAt(i) + "");
            stringSet.add(inputString.charAt(i) + "");
        }
        if (stringList.size() != stringSet.size()) {
            System.out.print(Massage.DUPLICATED_INPUT);
            return true;
        }
        return false;

    }

    private boolean inputCommandValid(String inputString) {
        boolean isValid = false;
        if (inputString.equals("1") || inputString.equals("2")) {
            isValid = true;
        }
        return isValid;
    }
}
