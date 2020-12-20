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

    public RestartMenu enterIfRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 눌러주세요.");
        return RestartMenu.getMatching(scanner.nextLine());
    }
}
