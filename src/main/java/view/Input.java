package view;

import domain.enums.Notice;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public Input() {
    }

    public String threeNumber() {
        System.out.print(Notice.INPUT_NUMBER.getMessage());
        return scanner.next();
    }
}
