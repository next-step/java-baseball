package baseball;


import baseball.domain.Inning;

import java.util.Arrays;
import java.util.Scanner;

public class play {

    public static void main(String[] args) {

        boolean isPlaying = true;

        while (isPlaying){
            isPlaying = playInning();
        }

    }

    private static boolean playInning() {
        Inning inning = Inning.newInning();
        boolean isOver = false;
        Scanner sc = new Scanner(System.in);
        while (!isOver){
            System.out.printf("숫자를 입력해주세요 : ");
           int[] guess = inputNum(sc);
            isOver = inning.pitch(guess);
        }

        return sc.nextInt() == 1;
    }

    private static int[] inputNum(Scanner sc) {
        int[] inputNumbers = new int[3];
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = sc.nextInt();
        }
        return inputNumbers;
    }

}
