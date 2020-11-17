import java.util.Scanner;

public class App {

    public static final int GAME_NUMBER_LENGTH = 3;
    private static final String GAME_PROCESS = "1";
    private static final String GAME_END = "2";
    private static final Scanner scanner = new Scanner(System.in);

    private static Game game;
    private static boolean gameProcess = true;

    public static void main(String[] args) {
        while (gameProcess) {
            game = Game.initialize(GAME_NUMBER_LENGTH);
            processGame();
        }
    }

    private static void processGame() {
        while (!game.isEnded()) {
            game.checkNumber(getUserNumberInput());
            System.out.println(game.getResult());
        }
        checkGameIsContinue();
    }

    private static String getUserNumberInput() {
        System.out.println("숫자를 입력해 주세요");
        String number = scanner.next();
        if (number.length() == GAME_NUMBER_LENGTH) {
            return number;
        }
        return getUserNumberInput();
    }

    private static void checkGameIsContinue() {
        if (getGameStartOrEndInput().equals(GAME_END)) {
            gameProcess = false;
        }
    }

    private static String getGameStartOrEndInput() {
        System.out.println("게임을 새로 시작하시려면 1, 종료하시려면 2를 입력하세요");
        String input = scanner.next();
        if (input.equals(GAME_PROCESS) || input.equals(GAME_END)) {
            return input;
        }
        return getGameStartOrEndInput();
    }


}
