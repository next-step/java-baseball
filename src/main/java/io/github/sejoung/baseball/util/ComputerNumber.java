package io.github.sejoung.baseball.util;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class ComputerNumber {

	public static String getNumber(int digit) {
		Set<Integer> result = new HashSet<>();
		while (result.size() < digit) {
			result.add(ThreadLocalRandom.current().nextInt(1, 9));
		}
		return setToString(result);
	}

	private static String setToString(Set<Integer> integers) {
		if (Objects.nonNull(integers)) {
			StringBuilder sb = new StringBuilder();
			integers.forEach(sb::append);
			return sb.toString();
		}
		throw new RuntimeException("난수 생성에 실패 했습니다.");
	}

}
