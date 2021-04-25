package baseballgame;

public class User {

	public void validateInput(String userInput) {
		if (userInput.length() != 3) {
			throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
		}
		if (!userInput.matches("^[0-9]*$")) {
			throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
		}
	}

}
