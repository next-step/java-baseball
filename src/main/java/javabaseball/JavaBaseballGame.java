package javabaseball;

public class JavaBaseballGame {
	private static final int BASEBALL_NUMBER_LENGTH = 3;

	public static void main(String[] args) {
		RandomNumberStringGenerator randomNumberStringGenerator = new RandomNumberStringGenerator();
		String answer = randomNumberStringGenerator.generate(BASEBALL_NUMBER_LENGTH);

		// TODO(jjeda): Implement baseball game
	}
}
