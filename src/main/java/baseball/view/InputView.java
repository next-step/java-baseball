package baseball.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private InputView() {}
    private static Scanner scanner = new Scanner(System.in);

    public static String gameNumberInput(){
        System.out.print("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    public static int restartInput() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

        try {
            int restartOption = scanner.nextInt();
            enterKeyInput();
            return restartOption;
        } catch (InputMismatchException inputMismatchException) {
            scanner = new Scanner(System.in);
            return restartInput();
        }
    }

    public static void enterKeyInput() {
        scanner.nextLine();
    }
}
