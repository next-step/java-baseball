import java.util.Random;

import number.HintsCount;
import number.IllegalNumberException;
import number.Numbers;
import number.NumbersGenerator;
import number.RandomNumbersGenerator;
import view.HintsCountRenderer;
import view.InputView;
import view.OutputView;
import view.PrintStreamOutputView;
import view.ScannerInputView;
import view.StrikeFirstHintsCountRenderer;

public class NumberBaseballGame {
	private static final String RESTART_COMMAND = "1";
	private static final String END_COMMAND = "2";

	private final InputView inputView;
	private final OutputView outputView;
	private final NumbersGenerator numbersGenerator;
	private final GameOverJudge gameOverJudge;
	private final HintsCountRenderer hintsCountRenderer;

	public NumberBaseballGame(InputView inputView, OutputView outputView, NumbersGenerator numbersGenerator,
		GameOverJudge gameOverJudge, HintsCountRenderer hintsCountRenderer) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.numbersGenerator = numbersGenerator;
		this.gameOverJudge = gameOverJudge;
		this.hintsCountRenderer = hintsCountRenderer;
	}

	private void run() {
		Numbers numbers = numbersGenerator.generate();
		boolean isRunning = true;
		while (isRunning) {
			outputView.printInputNumberMessage();
			Numbers inputNumbers = inputView.inputNumbers();
			HintsCount hintsCount = numbers.compareNumbers(inputNumbers);
			outputView.printHints(hintsCount, hintsCountRenderer);
			isRunning = !gameOverJudge.isGameOver(hintsCount);
		}
		outputView.printEndGameMessage(Numbers.LENGTH);
	}

	public void start() {
		boolean isRunning = true;
		while (isRunning) {
			run();
			outputView.printNewGameMessage(RESTART_COMMAND, END_COMMAND);
			String command = inputView.inputRestartCommand();
			isRunning = isRestart(command);
		}
	}

	private boolean isRestart(String command) {
		return command.equals(RESTART_COMMAND);
	}

	public static void main(String[] args) {
		try {
			NumberBaseballGame numberBaseballGame = generateGame();
			numberBaseballGame.start();
		} catch (IllegalNumberException e) {
			e.printStackTrace();
		}
	}

	private static NumberBaseballGame generateGame() {
		HintsCountRenderer hintsCountRenderer = new StrikeFirstHintsCountRenderer();
		OutputView outputView = new PrintStreamOutputView(System.out);
		InputView inputView = new ScannerInputView(System.in);
		NumbersGenerator numbersGenerator = new RandomNumbersGenerator(new Random());
		GameOverJudge gameOverJudge = new StrikeCountGameOverJudge();
		return new NumberBaseballGame(inputView, outputView, numbersGenerator, gameOverJudge, hintsCountRenderer);
	}
}
