package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class UserIO {
    private static final String INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String INPUT_IS_RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final Scanner scanner;

    public UserIO(Scanner scanner) {
        this.scanner = scanner;
    }

    // 5.2.3 : Method names are written in lowerCamelCase
    public int inputNumber() {
        System.out.print(INPUT_NUMBER_MSG);
        return this.scanner.nextInt();
    }

    public int inputIsRestart() {
        System.out.println(INPUT_IS_RESTART_MSG);
        return this.scanner.nextInt();
    }

}
