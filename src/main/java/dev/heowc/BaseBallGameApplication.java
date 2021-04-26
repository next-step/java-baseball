package dev.heowc;

import dev.heowc.ball.Balls;

import java.util.Scanner;

public class BaseBallGameApplication {

    private static final String INPUT_BALLS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ENDING_MESSAGE = Balls.SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 " + Command.START + ", 종료하려면 " +
            Command.END + "를 입력하세요.";

    public static void main(String[] args) {
        final BaseBallGame game = BaseBallGame.init();
        do {
            print(INPUT_BALLS_MESSAGE);
            game.start();
        } while (game.isRunning());

        gameStartOrEnd(args);
    }

    private static void gameStartOrEnd(String[] args) {
        println(ENDING_MESSAGE);
        println(RETRY_MESSAGE);

        final Scanner scanner = new Scanner(System.in);
        final Command command = Command.code(scanner.nextInt());
        if (command.isStart()) {
            main(args);
        }
    }

    private static void print(String value) {
        System.out.print(value);
    }

    private static void println(String value) {
        System.out.println(value);
    }
}
