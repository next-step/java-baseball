package domain;

import util.ValidationUtil;

import java.util.Scanner;

import static domain.BaseballGame.NUMBER_SIZE;

public class Player {

    public static int[] getPlayerInput(Scanner scanner) {
        char[] userInput = scanner.next().toCharArray();
        try {
            ValidationUtil.validateUserInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return charToInt(userInput);
    }

    private static int[] charToInt(char[] userInput) {
        int[] userInputNum = new int[3];
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int tmp = userInput[i] - '0';
            userInputNum[i] = tmp;
        }
        return userInputNum;
    }
}
