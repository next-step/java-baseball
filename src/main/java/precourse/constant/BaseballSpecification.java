package precourse.constant;

public enum BaseballSpecification {

	MAX_BASEBALLS(3),
	MIN_NUMBER(1),
	MAX_NUMBER(9);

	private int value;

	BaseballSpecification(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
