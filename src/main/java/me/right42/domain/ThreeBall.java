package me.right42.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import me.right42.exception.BallNumberDuplicationException;

public class ThreeBall {

	private final Set<BallNumber> balls = new HashSet<>();

	private static final int BALL_SIZE = 3;

	public static ThreeBall createThreeBall(Collection<Integer> ballNumbers){
		validateInputValue(ballNumbers);

		ThreeBall threeBall = new ThreeBall();
		for (Integer ballNumber : ballNumbers) {
			threeBall.balls.add(new BallNumber(ballNumber));
		}

		validateThreeBall(threeBall);
		return threeBall;
	}

	public Set<BallNumber> getBalls() {
		return Collections.unmodifiableSet(this.balls);
	}

	private static void validateInputValue(Collection<Integer> ballNumbers) {
		if (ballNumbers == null || ballNumbers.size() != BALL_SIZE) {
			throw new IllegalArgumentException("볼 사이즈는 3개입니다.");
		}
	}

	private static void validateThreeBall(ThreeBall threeBall) {
		if(threeBall.balls.size() != BALL_SIZE) {
			throw new BallNumberDuplicationException("볼 값은 중복불가 입니다.");
		}
	}


}
