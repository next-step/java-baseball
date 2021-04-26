package game;

import game.baseball.Baseball;

import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 :");
        int inputNumber = scanner.nextInt();

        baseball.makePlayerNumbers(inputNumber);
    }
}
