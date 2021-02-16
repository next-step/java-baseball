package BaseballGame.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_TRY_NUMBER_FORM = "%d이닝) 숫자를 입력해주세요 : ";
    public static int inputTryNumber(int inningCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(INPUT_TRY_NUMBER_FORM, inningCount);
        int number = scanner.nextInt();

        return number;
    }
}
