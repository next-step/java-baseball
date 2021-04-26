package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Converter {

	public static int toNumber(String raw) {
		return Integer.parseInt(raw);
	}

	public static boolean isNumber(String raw) {
		try {
			toNumber(raw);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static List<Integer> toList(int number) {
		List<Integer> list = new ArrayList<>();

		while (number > 0) {
			list.add(number % 10);
			number /= 10;
		}

		Collections.reverse(list);

		return list;
	}

}
