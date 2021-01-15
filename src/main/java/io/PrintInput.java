package io;

import java.util.Scanner;

public class PrintInput {
    private final Scanner scanner;

    public PrintInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String recieveUserNumber() {
        System.out.print("숫자를 입력하세요: ");
        return scanner.next();
    }

    public Integer askUserOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(scanner.next());
    }
}
