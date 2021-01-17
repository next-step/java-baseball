package baseball;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    // 5.2.3 : Method names are written in lowerCamelCase
    public int scanInt(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }
}
