package baseball.ui;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String enterBallNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return scanner.nextLine();
    }
}
