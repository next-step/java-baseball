import baseball.BaseballGame;

import java.util.Scanner;

public class GameStarter {

    private final static String COMMAND_START = "1";
    private final static String COMMAND_END = "2";

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.play();
    }

    String inputCommand() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.next();
        } while (!isCommand(input));
        return input;
    }

    private boolean isCommand(String input) {
        return input.equals(COMMAND_START) || input.equals(COMMAND_END);
    }
}
