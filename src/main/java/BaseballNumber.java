public class BaseballNumber {

	private final Integer value;
	private final Integer index;

	public BaseballNumber(Integer value, Integer index) {
		this.value = value;
		this.index = index;
	}

	public Integer getValue() {
		return value;
	}

	public Integer getIndex() {
		return index;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		BaseballNumber baseballNumber = (BaseballNumber)o;

		if (value != null ? !value.equals(baseballNumber.value) : baseballNumber.value != null)
			return false;
		return index != null ? index.equals(baseballNumber.index) : baseballNumber.index == null;
	}

	@Override
	public int hashCode() {
		int result = value != null ? value.hashCode() : 0;
		result = 31 * result + (index != null ? index.hashCode() : 0);
		return result;
	}
}
