package input;

import java.util.ArrayList;
import java.util.List;

public class ParseService {

	public List<Integer> parse(String input, int size) {
		List<Integer> result = new ArrayList<>(parseToIntegerList(input));
		if (result.size() != size) {
			throw new IllegalArgumentException();
		}

		return result;
	}

	private List<Integer> parseToIntegerList(String input) {
		List<Integer> inputNumbers = new ArrayList<>();
		for (String num : input.split("")) {
			inputNumbers.add(Integer.parseInt(num));
		}

		return inputNumbers;
	}
}
