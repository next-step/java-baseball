package baseball.util;

import java.util.*;

import baseball.view.Print;

public class Util {

    private static final Scanner scanner = new Scanner(System.in);

    public static int requestUserNumbers() {
        Print.requestUserNumbers();
        return scanner.nextInt();
    }

    public static int requestRestart() {
        Print.requestRestart();
        return scanner.nextInt();
    }


}
