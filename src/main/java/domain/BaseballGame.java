package domain;

import util.PrintUtil;
import util.ValidationUtil;

import java.util.Scanner;

public class BaseballGame {

    public void play(Scanner scanner) {
        initPrint();
        getUserInput(scanner);
    }

    private void initPrint() {
        PrintUtil.printInfo();
    }

    private void getUserInput(Scanner scanner) {
        char[] userInput = scanner.next().toCharArray();
        try {
            ValidationUtil.validateUserInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}