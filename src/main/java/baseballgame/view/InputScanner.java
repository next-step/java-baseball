package baseballgame.view;

import java.util.Scanner;

public class InputScanner {

    private static final Scanner scanner = new Scanner(System.in);

    public static String read() {
        return scanner.nextLine();
    }

}
