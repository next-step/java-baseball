package input;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getNumberInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
