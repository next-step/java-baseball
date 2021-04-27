package home.work.baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUtils {
	
	public static List<Integer> generateNums(int size) {
		if (size <= 0 || size > 9) throw new IllegalArgumentException("1 ~ 9개 숫자만 가능합니다.");
		List<Integer> numList = new ArrayList<>();
		for (int i = 1; i <= 9; i++) numList.add(i);
		Collections.shuffle(numList);
		return Collections.unmodifiableList(numList.subList(0, size));
	}

}
