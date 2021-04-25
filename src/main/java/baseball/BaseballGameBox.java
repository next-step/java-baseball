package baseball;

import java.util.Scanner;

import customtypes.GameResult;

public class BaseballGameBox {
    private static final int AGAIN_PLAY = 1;
    private static final int STOP_PLAY = 2;

    public static void main(String[] args) {
        int retryFlag = AGAIN_PLAY;

        while (retryFlag == AGAIN_PLAY) {
            Scanner scanner = new Scanner(System.in);
            BaseballGame baseballGame = new BaseballGame(new BaseballReferee(), new RandomGenerator());

            playOneGame(baseballGame, scanner);

            retryFlag = askRetry(scanner);
        }
    }

    private static void playOneGame(BaseballGame baseballGame, Scanner scanner) {
        GameResult gameResult = GameResult.NONE;

        while (gameResult != GameResult.WIN) {
            System.out.println("숫자를 입력해주세요: ");
            String playerInput = scanner.nextLine();

            gameResult = baseballGame.play(playerInput);
            printIfInvalidInput(gameResult);
        }
        System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
    }

    private static void printIfInvalidInput(GameResult gameResult) {
        if (gameResult == GameResult.INVALID_INPUT) {
            System.out.println("유효하지 않은 입력값입니다. (입력값은 3자리 숫자이고, 각 숫자는 1~9 사이의 중복되지 않은 수여야 합니다.)");
            return;
        }
    }

    private static int askRetry(Scanner scanner) {
        int retryFlag = 0;

        while (retryFlag != AGAIN_PLAY && retryFlag != STOP_PLAY) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            retryFlag = scanner.nextInt();
        }

        return retryFlag;
    }
}
