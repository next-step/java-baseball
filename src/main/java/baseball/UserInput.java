package baseball;

import java.util.Scanner;

public class UserInput {
    private static final String NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    // 5.2.3 : Method names are written in lowerCamelCase
    public int inputNumber() {
        System.out.print(NUMBER_MSG);
        return scanner.nextInt();
    }

    public int inputRestart() {
        System.out.println(RESTART_MSG);
        return scanner.nextInt();
    }

}
