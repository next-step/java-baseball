package baseball;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
	START(1),
	EXIT(2),
	;

	private static final Map<Integer, Operation> BY_VALUE = new HashMap<>();

	static {
		for (Operation e : values()) {
			BY_VALUE.put(e.value, e);
		}
	}

	private final int value;

	Operation(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Operation of(int value) {
		if (!BY_VALUE.containsKey(value)) {
			throw new InvalidOperationValueException(value);
		}
		return BY_VALUE.get(value);
	}
}
