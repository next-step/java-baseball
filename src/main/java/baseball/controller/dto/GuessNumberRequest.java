package baseball.controller.dto;

public class GuessNumberRequest {
	private int[] guessNumbers;

	public GuessNumberRequest(int[] guessNumbers) {
		this.guessNumbers = guessNumbers;
	}

	public int[] getGuessNumbers() {
		return guessNumbers;
	}
}
