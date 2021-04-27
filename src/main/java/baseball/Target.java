package baseball;

import java.util.List;
import java.util.Objects;

import utils.ListUtil;

public class Target {

	private List<Character> value;

	private Target(List<Character> value) {
		setValue(value);
	}

	public static Target of(List<Character> value) {
		return new Target(value);
	}

	public List<Character> getValue() {
		return value;
	}

	public void setValue(List<Character> value) {
		if (value.size() != BaseballGameModel.NUMBER_SIZE || ListUtil.hasOnlyNumber(value) == false) {
			throw new IllegalArgumentException("3자리 숫자만 허용합니다.");
		}

		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Target)) {
			return false;
		}
		Target target = (Target)o;
		return Objects.equals(value, target.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
