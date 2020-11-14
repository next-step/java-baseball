package baseball.view;

import baseball.domain.Balls;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static Balls balls() {
        System.out.print("숫자를 입력해주세요 : ");
        return new Balls(sc.nextLine());
    }

    public static boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(sc.nextLine());

        if (input == 1) {
            return true;
        }

        if (input == 2) {
            return false;
        }

        throw new IllegalArgumentException("잘못입력하셨습니다.");
    }
}
