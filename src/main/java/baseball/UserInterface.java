package baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

import static baseball.BaseBallRandomNumber.RANDOM_NUMBER_LENGTH;

public class UserInterface {
    private static final Pattern VALID_INPUT_PATTERN = Pattern.compile(String.format("[0-9]{%d}", RANDOM_NUMBER_LENGTH));
    private static final Scanner scanner = new Scanner(System.in);

    public static String printGuideAndScanUserInput() {
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = scanner.next();

        if (!VALID_INPUT_PATTERN.matcher(userInput).matches()) {
            return printGuideAndScanUserInput();
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
