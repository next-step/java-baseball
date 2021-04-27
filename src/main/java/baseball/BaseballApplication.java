package baseball;

import baseball.service.Console;

import java.util.Scanner;

public class BaseballApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command = 1;

        do {

            if (command == 1) {
                Console console = new Console(scanner);
                console.play();
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            command = scanner.nextInt();

            if (command > 2 || command < 1)
                System.out.println("잘못된 명령어 입니다.");

        } while (command != 2);

        scanner.close();
    }

}
