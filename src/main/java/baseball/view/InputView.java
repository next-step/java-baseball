package baseball.view;

import java.util.Scanner;

public class InputView {
    private InputView() {}
    private static final Scanner scanner = new Scanner(System.in);

    public static String gameNumberInput(){
        System.out.println("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }
}
