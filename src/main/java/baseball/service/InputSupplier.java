package baseball.service;

import java.util.Scanner;

public class InputSupplier {
    private static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        return scanner.nextLine();
    }
}
