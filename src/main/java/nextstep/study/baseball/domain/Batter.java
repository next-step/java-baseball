package nextstep.study.baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import nextstep.study.baseball.common.BaseConstants;

public class Batter {

	private Set<Integer> numbers = new LinkedHashSet<Integer>();

	public Batter() {
	}

	public List<Integer> generateRandomNumbers() {
		return this.generateRandomNumbers(BaseConstants.INPUT_NUMBER_LENGTH);
	}

	public List<Integer> generateRandomNumbers(int length) {
		if (length == 0) {
			return new ArrayList();
		}
		if (length > 9) {
			length = 9;
		}
		Random randNum = new Random();
		while (numbers.size() < length) {
			numbers.add(randNum.nextInt(9) + 1);
		}
		return new ArrayList<>(numbers);
	}

	public ArrayList<Integer> getNumbers() {
		return new ArrayList<>(numbers);
	}
}
