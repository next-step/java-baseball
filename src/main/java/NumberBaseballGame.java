import java.util.Random;

import number.IllegalNumberException;
import number.MatchResult;
import number.Numbers;
import number.NumbersGenerator;
import number.NumbersMatchResult;
import number.RandomNumbersGenerator;
import view.InputView;
import view.NumberMatchResultRenderer;
import view.OutputView;
import view.PrintStreamOutputView;
import view.RerunController;
import view.RerunControllerImpl;
import view.ScannerInputView;
import view.StrikeFirstResultRenderer;

public class NumberBaseballGame {
	private static final String RERUN_FLAG = "1";
	private static final String END_FLAG = "2";

	private final InputView inputView;
	private final OutputView outputView;
	private final NumbersGenerator numbersGenerator;
	private final NumberMatchResultRenderer numberMatchResultRenderer;
	private final RerunController rerunController;

	public NumberBaseballGame(InputView inputView, OutputView outputView, NumbersGenerator numbersGenerator,
		NumberMatchResultRenderer numberMatchResultRenderer, RerunController rerunController) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.numbersGenerator = numbersGenerator;
		this.numberMatchResultRenderer = numberMatchResultRenderer;
		this.rerunController = rerunController;
	}

	private void run() {
		Numbers numbers = numbersGenerator.generate();
		boolean isRunning = true;
		while (isRunning) {
			outputView.printInputNumberMessage();
			Numbers otherNumbers = inputView.inputNumbers();
			NumbersMatchResult numbersMatchResult = numbers.match(otherNumbers);
			outputView.printNumbersMatchResult(numbersMatchResult, numberMatchResultRenderer);
			isRunning = isGameContinue(numbersMatchResult);
		}
		outputView.printEndGameMessage(Numbers.LENGTH);
	}

	private boolean isGameContinue(NumbersMatchResult numbersMatchResult) {
		int strikeCount = numbersMatchResult.countOfResult(MatchResult.STRIKE);
		return strikeCount != Numbers.LENGTH;
	}

	public void start() {
		boolean isRunning = true;
		while (isRunning) {
			run();
			outputView.printRerunGameMessage(rerunController.getRerunFlag(), rerunController.getEndFlag());
			isRunning = rerunController.isRerun(inputView.inputRerunGameFlag());
		}
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
		NumberMatchResultRenderer numberMatchResultRenderer = new StrikeFirstResultRenderer();
		OutputView outputView = new PrintStreamOutputView(System.out);
		InputView inputView = new ScannerInputView(System.in);
		NumbersGenerator numbersGenerator = new RandomNumbersGenerator(new Random());
		RerunController reRunController = new RerunControllerImpl(RERUN_FLAG, END_FLAG);
		return new NumberBaseballGame(inputView, outputView, numbersGenerator, numberMatchResultRenderer,
			reRunController);
	}
}
