package ui;

import java.util.Scanner;


public class CommandLinePresentator implements Presentator {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String presentInputNumber() {
        System.out.println("숫자를 입력해주세요:");
        return scanner.next();
    }
}
