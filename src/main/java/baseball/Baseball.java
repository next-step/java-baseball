package baseball;

import java.util.Arrays;
import java.util.Scanner;

public class Baseball {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String retry;
        retry = playOneGame(scanner);

        while (retry.equals("1")) {
            retry = playOneGame(scanner);
        }
    }

    private static String playOneGame(Scanner scanner) {
        Game game;
        String retry;
        game = new Game(scanner);
        game.start();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        retry = scanner.nextLine();
        if (!Arrays.asList("1", "2").contains(retry)) {
            throw new IllegalArgumentException();
        }
        return retry;
    }
}
