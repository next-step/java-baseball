import java.util.Random;

import number.IllegalNumberException;
import number.MatchResult;
import number.Numbers;
import number.NumbersMatchResult;

public class NumberBaseballGame {

	private final View view;
	private final NumbersGenerator numbersGenerator;

	public NumberBaseballGame(View view, NumbersGenerator numbersGenerator) {
		this.view = view;
		this.numbersGenerator = numbersGenerator;
	}

	private void run() {
		Numbers numbers = numbersGenerator.generate();
		boolean isRunning = true;
		while (isRunning) {
			Numbers otherNumbers = view.inputNumbers();
			NumbersMatchResult numbersMatchResult = numbers.match(otherNumbers);
			view.renderResult(numbersMatchResult);
			isRunning = isGameContinue(numbersMatchResult);
		}
	}

	private boolean isGameContinue(NumbersMatchResult numbersMatchResult) {
		int strikeCount = numbersMatchResult.countOfResult(MatchResult.STRIKE);
		return strikeCount != Numbers.LENGTH;
	}

	public void start() {
		boolean isRunning = true;
		while (isRunning) {
			run();
			isRunning = false;
		}
	}

	public static void main(String[] args) {
		NumberMatchResultRenderer numberMatchResultRenderer = new StrikeFirstResultRenderer();
		View view = new View(System.in, numberMatchResultRenderer);
		NumbersGenerator numbersGenerator = new RandomNumbersGenerator(new Random());
		NumberBaseballGame numberBaseballGame = new NumberBaseballGame(view, numbersGenerator);
		try {
			numberBaseballGame.start();
		} catch (IllegalNumberException e) {
			e.printStackTrace();
		}
	}
}
