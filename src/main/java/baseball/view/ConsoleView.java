package baseball.view;

import java.util.Scanner;

public class ConsoleView implements GameView {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }
}
