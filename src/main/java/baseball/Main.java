package baseball;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        Scanner scan = new Scanner(System.in);
        int input = 1;
        while (input == 1) {
            baseBall.start();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = scan.nextInt();
        }
    }
}
