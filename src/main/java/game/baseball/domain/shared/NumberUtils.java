package game.baseball.domain.shared;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {
	public static int combine(List<Integer> numbers) {
		int totalNumber = 0;

		for(Integer number : numbers){
			totalNumber = totalNumber * 10 + number;
		}

		return totalNumber;
	}

	public static List<Integer> split(int number) {
		List<Integer> numbers = new ArrayList<>();

		while (number != 0) {
			numbers.add(0, number % 10);
			number /= 10;
		}

		return numbers;
	}
}
