package baseball;

class Game {
	private static final int NUMBER_LENGTH = 3;

	private Player player;
	private Computer computer;
	private Printer printer;
	private Input input;

	Game() {
		player = new Player(NUMBER_LENGTH);
		computer = new Computer(NUMBER_LENGTH);
		printer = new Printer();
		input = new Input(NUMBER_LENGTH);
	}

	void start() {
		int[] answer = computer.chooseNumbers();
		int[] guess = new int[] {-1, -1, -1};
		Judgement judgement = computer.judge(guess, answer);
		while (!judgement.isAllStrike()) {
			printer.printMessageOnBeforeGuess();
			guess = player.guess(input.getGuessInput());
			judgement = computer.judge(guess, answer);
			printer.printJudgement(judgement);
		}
		end();
	}

	private void end() {
		printer.printMessageOnEnd();
		ProceedType proceedType = player.proceed(input.getProceedInput());

		if (proceedType == ProceedType.RESTART)
			restart();

		if (proceedType == ProceedType.EXIT)
			exit();
	}

	private void restart() {
		start();
	}

	private void exit() {
		System.exit(0);
	}
}
