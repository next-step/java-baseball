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

    public static boolean askRegame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임 종료. 게임 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int response = scanner.nextInt();

        if (response == 1) {
            return true;
        }
        return false;
    }
}
