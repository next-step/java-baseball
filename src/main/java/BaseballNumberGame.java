import data.BaseballGameHint;
import data.BaseballNumbers;
import data.GameEndStatus;
import data.GameMessage;

public class BaseballNumberGame {

	private NumberGenerator numberGenerator;
	private UserInputScanner inputScanner;
	private BaseballNumberChecker checker;

	public BaseballNumberGame() {
		this.numberGenerator = new NumberGenerator();
		this.inputScanner = new UserInputScanner();
		this.checker = new BaseballNumberChecker();
	}

	public void run() {
		do {
			playGame();
		} while (inputScanner.getEndStatus() == GameEndStatus.RETRY);

	}
	public void playGame() {
		BaseballNumbers answer = numberGenerator.generateBaseballNumbers();
		BaseballGameHint hint;
		do {
			BaseballNumbers guessedNumber = inputScanner.getUserNumbers();
			hint = checker.getHint(guessedNumber, answer);
			printHint(hint);
		} while (hint.isWrongAnswer());
		System.out.println(GameMessage.MESSAGE_SUCCEEDED_FINISH);
	}

	private void printHint(BaseballGameHint hint) {
		if(hint.isCorrect()) {
			return;
		}
		System.out.println(hint.toHintString());
	}
}
