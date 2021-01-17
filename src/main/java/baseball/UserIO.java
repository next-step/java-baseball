package baseball;

import java.util.Scanner;

public class UserIO {
    protected final Scanner scanner;

    public UserIO(Scanner scanner) {
        this.scanner = scanner;
    }

    public int scanInt(String msg) {
        printMsg(msg);
        return scanner.nextInt();
    }

    public void printMsg(String msg) {
        System.out.print(msg);
    }
}
