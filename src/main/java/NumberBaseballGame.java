import java.util.Random;

import number.IllegalNumberException;
import number.Numbers;

public class NumberBaseballGame {

	private final View view;
	private final NumbersGenerator numbersGenerator;

	public NumberBaseballGame(View view, NumbersGenerator numbersGenerator) {
		this.view = view;
		this.numbersGenerator = numbersGenerator;
	}

	public void run() {
		Numbers numbers = numbersGenerator.generate();
		Numbers otherNumbers = view.inputNumbers();
	}

	public static void main(String[] args) {
		View view = new View(System.in);
		NumbersGenerator numbersGenerator = new RandomNumbersGenerator(new Random());
		NumberBaseballGame numberBaseballGame = new NumberBaseballGame(view, numbersGenerator);
		try {
			numberBaseballGame.run();
		} catch (IllegalNumberException e) {
			e.printStackTrace();
		}
	}
}
