package edu.nextstep.game;

import edu.nextstep.util.NumberUtil;

public class BaseballGamer {
	private String selectedNumber;

	public BaseballGamer(String selectedNumber) {
		this.selectedNumber = selectedNumber;
	}

	public static BaseballGamer generateComputer(int numberSize) {
		return new BaseballGamer(NumberUtil.generateNonDuplicatedNumber(numberSize));
	}

	public String getSelectedNumber() {
		return selectedNumber;
	}

	public String pickDigit(int index) {
		if (index < 0 || index >= selectedNumber.length()) {
			return "";
		}
		return selectedNumber.substring(index, index + 1);
	}
}
