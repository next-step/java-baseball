package baseball.view;

import java.util.Scanner;

public class InputView {
    public static String numbers() {
        System.out.println();
        System.out.print("숫자를 입력해주세요 : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int restartNumber() {
        System.out.println();
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
