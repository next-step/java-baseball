package nextstep.study.baseball.domain;

import nextstep.study.baseball.util.BaseballUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pitcher {

	private List<Integer> numbers = new ArrayList<Integer>();
	private final Scanner scanner;

	public Pitcher() {
		this(new Scanner(System.in));
	}

	public Pitcher(Scanner scanner) {
		this.scanner = scanner;
	}

	public String makeMixBallNumber() {
		numbers.clear();
		return this.processMakeMixBallNumber(true);
	}

	public String makeMixBallNumber(boolean validation) {
		numbers.clear();
		return this.processMakeMixBallNumber(validation);
	}

	private String processMakeMixBallNumber(boolean validation) {
		int makeCount = 0;
		boolean continues = true;
		String inputNums = null;
		while (continues) {
			BaseballUtil.showMessage(BaseballUtil.getInputMessage(makeCount++));
			inputNums = this.scanner.nextLine();
			continues = isContinuable(inputNums, validation);
		}
		numbers.addAll(BaseballUtil.convertStringToIntList(inputNums));
		return inputNums;
	}

	public boolean isContinuable(String inputNums, boolean validation) {
		if (!validation) {
			return false;
		}
		return !BaseballUtil.validationNumber(inputNums);
	}

	public ArrayList<Integer> getNumbers() {
		return new ArrayList<>(numbers);
	}

}
