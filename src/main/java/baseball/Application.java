package baseball;

import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.ThreeNumberGenerator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        NumberGenerator generator = new ThreeNumberGenerator();
        BaseballGameModel model = new BaseballGameModel(generator);
        runGameLoop(model, scanner);
    }

    private static void runGameLoop(BaseballGameModel model, Scanner scanner) {
        while (isGameEnd(model)) {
            processGame(model, scanner);
        }
    }

    private static void processGame(BaseballGameModel model, Scanner scanner) {
        model.setUserInput(scanner.nextLine());
        int[] result = model.guessNumber();
        int strike = result[0];
        int ball = result[1];
        System.out.println(model.printBallCountMessages(strike, ball));
        if (model.isRoundFinished()) {
            model.selectGame(scanner.nextLine());
        }
    }

    private static boolean isGameEnd(BaseballGameModel model) {
        return model.isEnd();
    }
}
