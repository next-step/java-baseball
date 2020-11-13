package baseball.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public static String getNumbers() {
        System.out.print(NUMBER_MESSAGE);
        return scanner.nextLine();
    }

}
