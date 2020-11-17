import baseball.BaseballDigitGenerator;
import baseball.BaseballGame;
import baseball.BaseballJudgeImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameStarter {

    private static List<String> INPUT_AVAILABLE_CHARS = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private final static int DIGITS = 3;
    private final static String COMMAND_START = "1";
    private final static String COMMAND_END = "2";

    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter();
        BaseballDigitGenerator baseballDigitGenerator = new BaseballDigitGenerator(INPUT_AVAILABLE_CHARS, DIGITS);
        BaseballGame baseballGame = new BaseballGame(baseballDigitGenerator, new BaseballJudgeImpl(DIGITS));
        do {
            baseballGame.play();
        } while (gameStarter.askPlayNewGame());
    }

    private boolean askPlayNewGame() {
        String guideMessage = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", COMMAND_START, COMMAND_END);
        System.out.println(guideMessage);
        String command = inputCommand();
        if (command.equals(COMMAND_START)) {
            return true;
        }

        return false;
    }

    private String inputCommand() {
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
