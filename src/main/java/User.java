import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class User {
	private final int INPUT_MAX_LENGTH = 3;

	private List<Integer> userNumbers;

	public List<Integer> getUserNumbers() {
		return userNumbers;
	}

	public void validateNumber(String inputValue) {
		if (inputValue.length() != INPUT_MAX_LENGTH) {
			throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
		}

		int intInput = Integer.parseInt(inputValue);
		Set<Integer> inputNumber = new LinkedHashSet<>();
		inputNumber.add(intInput / 100); // 100의 자리
		inputNumber.add((intInput % 100) / 10); // 10의 자리
		inputNumber.add(intInput % 10); // 1의 자리

		if (inputNumber.size() != INPUT_MAX_LENGTH) {
			throw new IllegalArgumentException("중복되는 수가 있습니다.");
		}

		userNumbers = new ArrayList<>(inputNumber);
	}
}
