package game.baseball.view;

import java.util.Scanner;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Supplier<String> numbers() {
        return () -> {
            System.out.print("숫자를 입력해주세요 : ");
            return SCANNER.next();
        };
    }

    public static IntSupplier command() {
        return () -> {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return SCANNER.nextInt();
        };
    }
}
