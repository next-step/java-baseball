package baseballgame;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

	public void validate(String userInput) {
		validateInputSize(userInput);
		validateInputHasCharacter(userInput);
		validateInputHasDuplicatedNumber(userInput);
	}

	private void validateInputSize(String userInput) {
		if (userInput.length() != 3) {
			throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
		}
	}

	private void validateInputHasCharacter(String userInput) {
		if (!userInput.matches("^[0-9]*$")) {
			throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
		}
	}

	private void validateInputHasDuplicatedNumber(String input) {
		List<String> inputList = Arrays.asList(input.split(""));
		Set<String> inputSet = new LinkedHashSet<>(inputList);

		if (input.length() != inputSet.size()) {
			throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
		}
	}

}
