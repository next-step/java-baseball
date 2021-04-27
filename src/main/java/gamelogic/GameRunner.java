package gamelogic;

import ui.GameplayUI;

public class GameRunner {

	private final GameAnswerGenerator gameAnswerGenerator = new GameAnswerGenerator();
	private final GameplayUI gameplayUI = new GameplayUI();

	public void runNewRound() {
		String answer = gameAnswerGenerator.generateAnswer();
		boolean isUserInputCorrect = false;
		while (!isUserInputCorrect) {
			String userInput = gameplayUI.getUserInput();
			isUserInputCorrect = checkUserInput(answer, userInput);
		}
		gameplayUI.printRoundEndMessage();
	}

	private boolean checkUserInput(String answer, String userInput) {
		if (answer.equals(userInput)) {
			return true;
		}
		int strikeCount = printAndReturnStrike(answer, userInput);
		int ballCount = printAndReturnBall(answer, userInput, strikeCount);
		if (strikeCount == 0 && ballCount == 0) {
			gameplayUI.printNothing();
		}
		return false;
	}

	private int printAndReturnStrike(String answer, String userInput) {
		int count = countStrike(answer, userInput);
		gameplayUI.printStrike(count);
		return count;
	}

	private int countStrike(String answer, String userInput) {
		int count = 0;
		for (int i = 0; i < 3; ++i) {
			count += answer.charAt(i) == userInput.charAt(i) ? 1 : 0;
		}
		return count;
	}

	private int printAndReturnBall(String answer, String userInput, int strikeCount) {
		int[] answerDigit = new int[11];
		int[] userInputDigit = new int[11];
		for (int i = 0; i < 3; ++i) {
			++answerDigit[answer.charAt(i) - '0'];
			++userInputDigit[userInput.charAt(i) - '0'];
		}
		int count = countBall(answerDigit, userInputDigit, strikeCount);
		gameplayUI.printBall(count);
		return count;
	}

	private int countBall(int[] answerDigit, int[] userInputDigit, int strikeCount) {
		int count = 0;
		for (int i = 1; i <= 10; ++i) {
			count += (answerDigit[i] == 1 && userInputDigit[i] == 1) ? 1 : 0;
		}
		return count - strikeCount;
	}
}
