package me.right42.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.right42.exception.BallNumberDuplicationException;

public class ThreeBall {

	private final Set<BallNumber> balls = new HashSet<>();

	private static final int BALL_SIZE = 3;

	private ThreeBall(String ballNumbers) {
		validateValue(ballNumbers);

		for (Integer ballNumber : parseValue(ballNumbers)) {
			balls.add(new BallNumber(ballNumber));
		}

		validateThreeBall();
	}
	public static ThreeBall createThreeBall(String ballNumbers){
		return new ThreeBall(ballNumbers);
	}

	public Set<BallNumber> getBalls() {
		return Collections.unmodifiableSet(this.balls);
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
			throw new IllegalArgumentException("볼 사이즈는 3개입니다.");
		}
	}

	private void validateThreeBall() {
		if(this.balls.size() != BALL_SIZE) {
			throw new BallNumberDuplicationException("볼 값은 중복불가 입니다.");
		}
	}
}
