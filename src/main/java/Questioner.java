import java.util.concurrent.ThreadLocalRandom;

import validator.NumberFormatValidator;

public class Questioner {

	public int makeProblem() {
		int random = generate();
		while (!NumberFormatValidator.isValidate((random))) {
			random = generate();
		}
		return random;
	}

	private int generate() {
		return ThreadLocalRandom.current().nextInt(100, 1000);
	}

}
