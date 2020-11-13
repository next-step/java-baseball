package baseball;

import java.util.Scanner;

class BaseballGameScanner {

    private Scanner scanner = new Scanner(System.in);


    String scan() {
        String inputData;
        do {
            inputData = scanner.nextLine();
        } while (!checkValidate(inputData));

        return inputData;
    }

    private boolean checkValidate(String input) {
        if (input.length() != 3) {
            System.out.print("숫자가 3자리가 아닙니다. 다시 입력하세요 : ");
            return false;
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.print("숫자만 입력하세요. 다시 입력하세요 : ");
            return false;
        }

        return true;
    }
}
