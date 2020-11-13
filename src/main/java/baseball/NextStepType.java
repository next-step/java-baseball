package baseball;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2020-11-13
 */
public enum NextStepType {
	RESTART(1),
	EXIT(2);

	private final int code;

	private static final Map<Integer, NextStepType> lookup = new HashMap<>();

	static {
		for (NextStepType n : NextStepType.values()) {
			lookup.put(n.code, n);
		}
	}

	NextStepType(int code) {
		this.code = code;
	}

	public static NextStepType findBy(int code) {
		NextStepType nextStepType = lookup.get(code);
		if (nextStepType == null) {
			throw new WrongNextStepInputException();
		}

		return nextStepType;
	}
}
