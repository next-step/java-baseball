package baseball;


import baseball.domain.Inning;

import java.util.Arrays;
import java.util.Scanner;

public class play {

    public static void main(String[] args) {

        boolean isPlaying = true;

        while (isPlaying) {
            isPlaying = playInning();
        }

    }

    private static boolean playInning() {
        Inning inning = Inning.newInning();
        boolean isOver = false;
        Scanner sc = new Scanner(System.in);
        while (!isOver) {
            System.out.printf("숫자를 입력해주세요 : ");
            String guess = inputNum(sc);
            isOver = inning.pitch(guess);
        }

        return sc.nextInt() == 1;
    }

    private static String inputNum(Scanner sc) {
        boolean rightNumber = false;
        String inputNumbers = "";
        while (!rightNumber) {
            inputNumbers = sc.next();
            rightNumber = checkInput(inputNumbers);
        }

        return inputNumbers;
    }

    private static boolean checkInput(String input) {

        if (input.matches("^\\d{3}")) {
            return true;
        }
        System.out.println("3자리 숫자를 입력해주세요.");
        return false;
    }

}
