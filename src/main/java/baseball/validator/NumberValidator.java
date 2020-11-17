package baseball.validator;

import static baseball.utils.DataConvertUtils.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidator {

	static final String NULL_MESSAGE = "요청된 번호가 없습니다.";
	static final String DUPLICATE_MESSAGE = "중복된 번호가 있습니다.";
	static final String INVALID_MESSAGE = "유효한 요청 번호가 아닙니다.";

	public void validate(List<Integer> numbers) {
		if (numbers == null)
			throw new IllegalArgumentException(NULL_MESSAGE);

		checkDuplicate(numbers);
	}

	public void validate(String numbers) {
		if (numbers == null || "".equals(numbers))
			throw new IllegalArgumentException(NULL_MESSAGE);

		checkValidNumbers(numbers);

		this.validate(convertToIntegerArrays(numbers));
	}

	private void checkDuplicate(List<Integer> numbers) {
		Set<Integer> unique = new HashSet<>(numbers);
		if (unique.size() != numbers.size())
			throw new IllegalArgumentException(DUPLICATE_MESSAGE);

	}

	private void checkValidNumbers(String numbers) {
		Pattern compile = Pattern.compile("^[1-9]{3}$");
		Matcher matcher = compile.matcher(numbers);
		if (!matcher.find())
			throw new IllegalArgumentException(INVALID_MESSAGE);

	}
}
