package io.github.sejoung.baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import io.github.sejoung.baseball.constants.GameStatus;
import io.github.sejoung.baseball.validator.BaseBallValidator;

public class BaseBallGame {

	private final List<Set<Integer>> computerNumberList;

	private GameStatus status;

	private boolean isThreeStrike = false;

	public GameStatus getStatus() {
		return status;
	}

	public BaseBallGame(String computerNumber) {
		this.computerNumberList = makeNumberList(computerNumber);
		this.status = GameStatus.DOING;
	}

	private List<Set<Integer>> makeNumberList(String computerNumber) {
		Set<Integer> baseballNumber = new HashSet<>();
		char[] chars = computerNumber.toCharArray();
		for (char number : chars) {
			baseballNumber.add(Character.getNumericValue(number));
		}
		return conversionSet(baseballNumber);
	}

	private List<Set<Integer>> conversionSet(Set<Integer> baseballNumber) {
		List<Set<Integer>> numberList = new ArrayList<>();
		baseballNumber.forEach(integer -> {
			Set<Integer> tempSet = new HashSet<>();
			tempSet.add(integer);
			numberList.add(tempSet);
		});
		return numberList;
	}

	public String play(String input) {
		String validationMessage = valid(input);
		if (!isEmpty(validationMessage)) {
			return validationMessage;
		}
		if (isThreeStrike) {
			changeStatus(input);
			return "";
		}
		return check(input);
	}

	private boolean isEmpty(String validationMessage) {
		return Objects.isNull(validationMessage) || "".equals(validationMessage);
	}

	private String check(String input) {
		BaseBallNumber baseBallNumber = new BaseBallNumber(computerNumberList, input);
		String message = baseBallNumber.check();
		isThreeStrike = baseBallNumber.isThreeStrike();
		return message;
	}

	private void changeStatus(String input) {

		if ("1".equals(input)) {
			status = GameStatus.RESTART;
		}

		if ("2".equals(input)) {
			status = GameStatus.END;
		}

	}

	private String valid(String input) {
		try {
			BaseBallValidator validator = new BaseBallValidator(input, isThreeStrike);
			validator.valid();
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}
		return "";
	}

}
