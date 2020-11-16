package baseball.validator;

import static baseball.utils.DataConvertUtils.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {
	public boolean validate(List<Integer> numbers) {
		if (numbers == null)
			return false;

		return !isDuplicate(numbers);
	}

	public boolean validate(String numbers) {
		if (numbers == null ||
			!isNumbers(numbers)
		)
			return false;

		return this.validate(convertToIntegerArrays(numbers));
	}

	private boolean isDuplicate(List<Integer> numbers) {
		Set<Integer> unique = new HashSet<>(numbers);
		return unique.size() != numbers.size();
	}

	private boolean isNumbers(String numbers) {
		Pattern compile = Pattern.compile("^[1-9]{3}$");
		Matcher matcher = compile.matcher(numbers);
		return matcher.find();
	}
}
