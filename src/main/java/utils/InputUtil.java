package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.next();
    }

    public static List<Integer> transferStringToIntegerList(String input) {
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            integers.add(input.charAt(i) - '0');
        }

        return integers;
    }
}
