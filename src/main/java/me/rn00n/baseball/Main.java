package me.rn00n.baseball;

import java.util.Scanner;

public class Main {
    static int numberLength = 3;
    public static void main(String[] args) {
        Baseball baseball = new Baseball(numberLength);
        int coin = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            baseball.startGame();

            System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
            coin = scanner.nextInt();
            if (coin == 2) break;
        }
    }
}
