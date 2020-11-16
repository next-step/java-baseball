import app.BaseballGame;
import app.InputValidator;
import app.NumberGenerator;
import app.Score;

import java.util.Scanner;

public class Main {

    public static final String INPUT_VALID_MESSAGE = "입력값은 3자리의 숫자여야 합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 :";

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String generateNumber = NumberGenerator.generate();
        BaseballGame baseballGame = new BaseballGame(generateNumber);
        boolean gameStatus = true;
        while (gameStatus) {
            System.out.println(INPUT_NUMBER_MESSAGE);
            String input = scanner.next();
            if (!InputValidator.isValid(input)) {
                System.out.println(INPUT_VALID_MESSAGE);
                continue;
            }
            Score score = baseballGame.guess(input);
            gameStatus = score.getStatus();
            System.out.println(score.getResultMessage());
        }
    }
}
