package view;

import domain.Numbers;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static Numbers getUserNumbers() {
        System.out.println("숫자를 입력해주세요 :");
        return Numbers.valueOf(scanner.next());
    }

    public static boolean getMoreGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int system = scanner.nextInt();
        return system == 1? true : false;
    }
}
