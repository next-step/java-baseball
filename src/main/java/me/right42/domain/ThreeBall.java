package me.right42.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.right42.domain.type.BallMatchType;
import me.right42.exception.BallNumberDuplicationException;

public class ThreeBall {

	private final List<BallNumber> balls = new ArrayList<>();

	private static final int BALL_SIZE = 3;

	private ThreeBall(String ballNumbers) {
		validateValue(ballNumbers);

		for (Integer number : parseValue(ballNumbers)) {
			BallNumber ballNumber = new BallNumber(number);
			validateBallNumber(ballNumber);
			balls.add(ballNumber);
		}
	}

	public static ThreeBall createThreeBall(String ballNumbers){
		return new ThreeBall(ballNumbers);
	}

	public List<BallNumber> getBalls() {
		return Collections.unmodifiableList(this.balls);
	}

	public BallMatchResult compareTo(ThreeBall target) {
		BallMatchResult result = new BallMatchResult();

		for (int index = 0; index < target.getBalls().size(); index++) {
			BallNumber ballNumber = target.getBalls().get(index);
			result.addCount(checkMatchType(ballNumber, index));
		}

		return result;
	}

	private BallMatchType checkMatchType(BallNumber ballNumber, int index) {
		if(this.balls.contains(ballNumber)) {
			return compareValueAndIndex(ballNumber, index);
		}

		return BallMatchType.NOTHING;
	}

	private BallMatchType compareValueAndIndex(BallNumber targetBallNumber, int index) {
		if(this.balls.indexOf(targetBallNumber) == index) {
			return BallMatchType.STRIKE;
		}

		return BallMatchType.BALL;
	}

	private List<Integer> parseValue(String value) {
		List<Integer> ballNumbers = new ArrayList<>();
		for (String ballNumber : value.split("")) {
			ballNumbers.add(Integer.valueOf(ballNumber));
		}

		return ballNumbers;
	}

	private void validateValue(String value) {
		if (value == null || value.length() != BALL_SIZE) {
			throw new IllegalArgumentException(String.format("볼 사이즈는 %d개 입니다.", BALL_SIZE));
		}
	}

	private void validateBallNumber(BallNumber ballNumber) {
		if(balls.contains(ballNumber)) {
			throw new BallNumberDuplicationException("볼 값은 중복불가 입니다.");
		}
	}
}
