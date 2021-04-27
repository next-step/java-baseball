package me.right42.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import me.right42.domain.type.BallMatchType;
import me.right42.exception.BallNumberDuplicationException;

public class BallNumbers {

	private final List<BallNumber> balls = new ArrayList<>();

	private static final int BALL_SIZE = 3;

	private BallNumbers(List<Integer> numbers) {
		validateSize(numbers);

		for (Integer number : numbers) {
			BallNumber ballNumber = new BallNumber(number);
			validateDuplicateBallNumber(ballNumber);
			balls.add(ballNumber);
		}
	}

	public static BallNumbers create(String ballNumbers){
		return new BallNumbers(parseValue(ballNumbers));
	}

	public static BallNumbers create(List<Integer> ballNumbers){
		return new BallNumbers(ballNumbers);
	}

	public List<BallNumber> getBalls() {
		return Collections.unmodifiableList(this.balls);
	}

	public BallMatchResult compareTo(BallNumbers target) {
		BallMatchResult result = new BallMatchResult();

		for (int index = 0; index < target.getBalls().size(); index++) {
			BallNumber targetBallNumbers = target.getBalls().get(index);
			result.addCount(checkMatchType(targetBallNumbers, index));
		}

		return result;
	}

	private BallMatchType checkMatchType(BallNumber targetBallNumbers, int index) {
		if(this.balls.contains(targetBallNumbers)) {
			return compareValueAndIndex(targetBallNumbers, index);
		}

		return BallMatchType.NOTHING;
	}

	private BallMatchType compareValueAndIndex(BallNumber targetBallNumber, int index) {
		if(this.balls.indexOf(targetBallNumber) == index) {
			return BallMatchType.STRIKE;
		}

		return BallMatchType.BALL;
	}

	private static List<Integer> parseValue(String value) {
		List<Integer> ballNumbers = new ArrayList<>();
		for (String ballNumber : value.split("")) {
			ballNumbers.add(Integer.valueOf(ballNumber));
		}

		return ballNumbers;
	}

	private void validateSize(List<Integer> ballNumbers) {
		if (ballNumbers == null || ballNumbers.size() != BALL_SIZE) {
			throw new IllegalArgumentException(String.format("볼 사이즈는 %d개 입니다.", BALL_SIZE));
		}
	}

	private void validateDuplicateBallNumber(BallNumber ballNumber) {
		if(balls.contains(ballNumber)) {
			throw new BallNumberDuplicationException("볼 값은 중복불가 입니다.");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallNumbers that = (BallNumbers)o;
		return Objects.equals(balls, that.balls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balls);
	}
}
