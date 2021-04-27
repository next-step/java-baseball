package baseball;

import baseball.service.Console;

import java.util.Scanner;

public class BaseballApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Console console = new Console(scanner);
            console.play();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int command = scanner.nextInt();

            if (command == 2)
                break;
        }
        scanner.close();
    }

}
