package baseball;

import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.ThreeNumberGenerator;
import baseball.view.BaseballGameConsoleView;
import baseball.view.BaseballGameView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        BaseballGameView view = new BaseballGameConsoleView();
        NumberGenerator generator = new ThreeNumberGenerator();
        BaseballGameModel model = new BaseballGameModel(generator);
        runGameLoop(model, view, scanner);
    }

    private static void runGameLoop(BaseballGameModel model, BaseballGameView view, Scanner scanner) {
        while (isGameEnd(model)) {
            processGame(model, view, scanner);
        }
    }

    private static void processGame(BaseballGameModel model, BaseballGameView view, Scanner scanner) {
        view.showAskingForInputMessage();
        String value = scanner.nextLine();
        model.setUserInput(UserInput.of(value));
        view.showBallCountMessage(model.guessNumber());
        if (view.showFinishMessage(model.isRoundFinished())) {
            model.selectGame(scanner.nextLine());
        }
    }

    private static boolean isGameEnd(BaseballGameModel model) {
        return model.isEnd();
    }
}
