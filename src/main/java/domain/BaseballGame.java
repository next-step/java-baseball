package domain;

import utils.BaseballUtils;

import java.util.Scanner;

public class BaseballGame {
    public static void start() {
        boolean isValid = false;

        while (!isValid) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("숫자를입력해주세요 : ");
            String inputString = scanner.nextLine();
            isValid = BaseballUtils.isValidInput(inputString);
        }
    }
}
