package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

import static baseball.BaseBallRandomNumber.RANDOM_NUMBER_LENGTH;

public class UserInterface {
    public static String COMMAND_ANOTHER_GAME = "1";
    public static String COMMAND_EXIT_GAME = "2";

    private static final Pattern VALID_GUESS_NUMBER_PATTERN = Pattern.compile(String.format("[1-9]{%d}", RANDOM_NUMBER_LENGTH));
    private static final Scanner scanner = new Scanner(System.in);

    public static String printGuideAndScanGuessNumber() {
        String userInput = "";
        while (!VALID_GUESS_NUMBER_PATTERN.matcher(userInput).matches()) {
            System.out.print("숫자를 입력해 주세요 : ");
            userInput = scanner.nextLine().trim();
        }
        return userInput;
    }

    public static String printGuideAndScanExitCommand() {
        String userInput = "";
        while (!userInput.equals(COMMAND_ANOTHER_GAME) && !userInput.equals(COMMAND_EXIT_GAME)) {
            System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요\n", COMMAND_ANOTHER_GAME, COMMAND_EXIT_GAME);
            userInput = scanner.nextLine().trim();
        }
        return userInput;
    }

    public static void printGuessResult(BaseBallGuessResult guessResult) {
        printStrike(guessResult.getStrikeCount());
        printBall(guessResult.getBallCount());
        printFourBall(guessResult.isFourBall());
        System.out.println();
    }

    public static void printStrike(int strike) {
        if (strike > 0) {
            System.out.printf("%d 스트라이크 ", strike);
        }
    }

    public static void printBall(int ball) {
        if (ball > 0) {
            System.out.printf("%d 볼", ball);
        }
    }

    public static void printFourBall(boolean isFourBall) {
        if (isFourBall) {
            System.out.print("포볼");
        }
    }

    public static void printGameComplete() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }
}
