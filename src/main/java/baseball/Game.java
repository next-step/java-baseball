package baseball;

class Game {
	private static final int NUMBER_LENGTH = 3;

	private Player player;
	private Computer computer;
	private Console console;
	private Input input;
	private int[] answer;

	Game() {
		player = new Player(NUMBER_LENGTH);
		computer = new Computer(NUMBER_LENGTH);
		console = new Console();
		input = new Input(NUMBER_LENGTH);
	}

	GameExitCode start() {
		prepare();

		play();

		return end();
	}

	private void prepare() {
		answer = computer.chooseNumbers();
	}

	private void play() {
		Judgement judgement;

		do {
			console.printMessageOnBeforeGuess();
			int[] guess = player.guess(input.getGuessInput());
			judgement = computer.judge(guess, answer);
			console.printJudgement(judgement);
		} while (!judgement.isAllStrike());
	}

	private GameExitCode end() {
		console.printMessageOnEnd();
		return player.exit(input.getGameExitCodeInput());
	}
}
