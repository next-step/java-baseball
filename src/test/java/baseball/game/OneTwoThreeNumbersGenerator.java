package baseball.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneTwoThreeNumbersGenerator implements NumbersGenerator {

	@Override
	public List<Integer> getNumberPool() {
		return new ArrayList<>(Arrays.asList(1, 2, 3));
	}

	@Override
	public List<Integer> generate(int count) {
		return new ArrayList<>(Arrays.asList(1, 2, 3));
	}

	@Override
	public int getLimitCount() {
		return 3;
	}
}
