package domain;

import util.PrintUtil;
import util.ValidationUtil;

import java.util.Scanner;

public class BaseballGame {

    public void play(Scanner scanner) {
        initPrint();
        int[] userInput = getUserInput(scanner);
    }

    private void initPrint() {
        PrintUtil.printInfo();
    }

    private int[] getUserInput(Scanner scanner) {
        char[] userInput = scanner.next().toCharArray();
        try {
            ValidationUtil.validateUserInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return charToInt(userInput);
    }

    private int[] charToInt(char[] userInput) {
        int[] userInputNum = new int[3];
        for (int i = 0; i < 3; i++) {
            int tmp = userInput[i] - '0';
            userInputNum[i] = tmp;
        }
        return userInputNum;
    }

}