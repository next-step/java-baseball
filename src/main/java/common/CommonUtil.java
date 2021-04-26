package common;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommonUtil {
    public static String scannerNextMessageAndPattern(String message, String pattern) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        try {
            return scanner.next(pattern);
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            scanner.nextLine();
            scannerNextMessageAndPattern(message, pattern);
        }
        return null;
    }

    public static List<Integer> getInputStringToIntegerList(String input) {
        List<Integer> inputThrowBallList = new ArrayList<>();

        for (char inputThrowBall : input.toCharArray()) {
            inputThrowBallList.add(Integer.parseInt(String.valueOf(inputThrowBall)));
        }

        return inputThrowBallList;
    }
}
