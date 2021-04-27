package baseball;

import java.util.Scanner;

import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.ThreeNumberGenerator;
import baseball.view.BaseballGameConsoleView;
import baseball.view.BaseballGameView;

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
			proceedGameProcess(model, view, scanner);
		}
	}

	private static void proceedGameProcess(BaseballGameModel model, BaseballGameView view, Scanner scanner) {
		view.showAskingForInputMessage();
		model.setUserInput(UserInput.of(scanner.nextLine()));
		view.showBallCountMessage(model.guessNumber());
		if (view.showFinishMessage(model.isRoundFinished())) {
			model.selectGame(scanner.nextLine());
		}
	}

	private static boolean isGameEnd(BaseballGameModel model) {
		return model.isEnd();
	}
}
