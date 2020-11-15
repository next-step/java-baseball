package com.jaeeyeonling.baseball.view;

import java.io.InputStream;
import java.util.Scanner;

public final class InputView implements AutoCloseable {

    private final Scanner scanner;

    private InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView ofSystem() {
        return of(System.in);
    }

    public static InputView of(final InputStream stream) {
        return of(new Scanner(stream));
    }

    public static InputView of(final Scanner scanner) {
        return new InputView(scanner);
    }

    public String readBalls() {
        return scanner.nextLine();
    }

    public int getCommand() {
        return scanner.nextInt();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
