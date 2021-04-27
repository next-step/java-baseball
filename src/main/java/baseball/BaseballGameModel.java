package baseball;

import baseball.numbergenerator.NumberGenerator;

public final class BaseballGameModel {

	public static final String GAME_RESTART = "1";
	public static final String GAME_EXIT = "2";
	public static final int NUMBER_SIZE = 3;
	private final NumberGenerator numberGenerator;
	private UserInput userInput;
	private Target target;
	private boolean isRoundFinished = false;
	private boolean isEnd = true;

	public BaseballGameModel(UserInput userInput, NumberGenerator numberGenerator) {
		this(numberGenerator);
		setUserInput(userInput);
	}

	public BaseballGameModel(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
		setTarget(numberGenerator.create());
	}

	public void setUserInput(UserInput userInput) {
		this.userInput = userInput;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public UserInput userInput() {
		return userInput;
	}

	private Target target() {
		return target;
	}

	public GameResult guessNumber() {
		GameResult result = comparing(userInput(), target());
		if ((result.isFullStrike())) {
			isRoundFinished = true;
		}
		return result;
	}

	private GameResult comparing(UserInput input, Target target) {
		int strike = 0, ball = 0;
		for (int i = 0; i < NUMBER_SIZE; i++) {
			Character inputChar = input.getValue().get(i);
			Character targetChar = target.getValue().get(i);

			strike = addOneIfTrue(strike, inputChar == targetChar);
			ball = addOneIfTrue(ball, inputChar != targetChar && target.getValue().contains(inputChar));
		}
		return new GameResult(strike, ball);
	}

	private int addOneIfTrue(int number, boolean condition) {
		if (condition) {
			number = number + 1;
		}
		return number;
	}

	public boolean isRoundFinished() {
		return isRoundFinished;
	}

	public void restart() {
		setTarget(numberGenerator.create());
		isRoundFinished = false;
		isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void end() {
		isEnd = false;
	}

	public void selectGame(String option) {
		option = option.trim();
		if (option.equals(GAME_RESTART)) {
			this.restart();
			return;
		}
		if (option.equals(GAME_EXIT)) {
			this.end();
			return;
		}
		throw new IllegalArgumentException("1 또는 2를 입력하세요.");
	}
}
