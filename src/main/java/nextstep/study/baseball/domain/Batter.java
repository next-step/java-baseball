package nextstep.study.baseball.domain;

import nextstep.study.baseball.common.BaseConstants;

import java.util.*;

public class Batter {

	private Set<Integer> numbers = new LinkedHashSet<Integer>();

	public Batter() {
		this.generateRandomNumbers();
	}

	public List<Integer> generateRandomNumbers() {
		List<Integer> list = this.generateRandomNumbers(BaseConstants.INPUT_NUMBER_LENGTH);
		System.out.println("타자번호 : " + list);
		return list;
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
