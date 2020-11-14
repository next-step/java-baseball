package me.totoku103.baseball;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputSystem {
    private final int inputMaxLength;
    private final Pattern inputPattern;
    private final Scanner scanner;

    public InputSystem(int inputMaxLength) {
        this.inputMaxLength = inputMaxLength;
        this.inputPattern = Pattern.compile(String.format("\\d{%d}", this.inputMaxLength));
        this.scanner = new Scanner(System.in);
    }

    public String input(MessageConstants message) {
        try {
            System.out.println(message.getMessage());
            return scanner.next(inputPattern);
        } catch (InputMismatchException e) {
            System.out.println(MessageConstants.INVALID_INPUT.getMessage() + ":" + scanner.nextLine());
            return this.input(message);
        }
    }
}
