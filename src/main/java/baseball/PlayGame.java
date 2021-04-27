package baseball;


import baseball.domain.Inning;

import java.util.Scanner;

public class PlayGame {

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
        boolean isRightNumber = false;
        String inputNumbers = "";
        while (!isRightNumber) {
            inputNumbers = sc.next();
            isRightNumber = checkInput(inputNumbers);
        }

        return inputNumbers;
    }

    public static boolean checkInput(String input) {

        if (input.matches("^\\d{3}")) {
            return true;
        }
        System.out.println("3자리 숫자를 입력해주세요.");
        return false;
    }

}
