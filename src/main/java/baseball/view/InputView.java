package baseball.view;

import java.util.Scanner;

public class InputView {
    private InputView() {}
    private static final Scanner scanner = new Scanner(System.in);

    public static String gameNumberInput(){
        System.out.println("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    public static int restartInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를입 력하세요");
        return scanner.nextInt();
    }

    public static void enterInput() {
        scanner.nextLine();
    }
}
