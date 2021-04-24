package number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
	private static final int SUITABLE_SIZE = 3;

	private final List<Integer> baseballNumbers;

	public BaseballNumbers(List<Integer> baseballNumbers) {
		validateSuitableSize(baseballNumbers);
		validateBetweenOneAndNine(baseballNumbers);
		validateDuplication(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}

	private void validateSuitableSize(List<Integer> baseballNumbers) {
		if (baseballNumbers.size() != SUITABLE_SIZE) {
			throw new IllegalArgumentException("세자리의 수가 아닙니다.");
		}
	}

	private void validateDuplication(List<Integer> baseballNumbers) {
		Set<Integer> nonDuplicate = new HashSet<>(baseballNumbers);

		if (baseballNumbers.size() != nonDuplicate.size()) {
			throw new IllegalArgumentException("숫자에 중복이 존재합니다.");
		}
	}

	private void validateBetweenOneAndNine(List<Integer> baseballNumbers) {
		if (baseballNumbers.contains(Integer.valueOf(0))) {
			throw new IllegalArgumentException("1~9의 숫자로 구성되어 있지 않습니다.");
		}
	}

	public List<Integer> getBaseballNumbers() {
		return baseballNumbers;
	}

	public int size() {
		return baseballNumbers.size();
	}

	public Integer get(int index) {
		return baseballNumbers.get(index);
	}

	@Override
	public String toString() {
		return baseballNumbers.toString();
	}

}
