package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Balls {

	public static final int BALL_NUMBER_SIZE = 3;
	private final List<Ball> balls;

	public Balls(List<Integer> ballNumbers) {
		validateBallNumbers(ballNumbers);
		this.balls = mapBall(ballNumbers);
	}

	private List<Ball> mapBall(List<Integer> ballNumbers) {
		List<Ball> balls = new ArrayList<>();

		for (int i = 0; i < ballNumbers.size(); i++) {
			balls.add(new Ball(i, ballNumbers.get(i)));
		}

		return balls;
	}

	public BallStatus play(Ball userBall) {
		return balls.stream()
			.map(answer -> answer.play(userBall))
			.filter(BallStatus::isNotNothing)
			.findFirst()
			.orElse(BallStatus.NOTHING);
	}

	private void validateBallNumbers(List<Integer> ballNumbers) {
		validateSize(ballNumbers);
		validateDuplicate(ballNumbers);
	}

	private void validateSize(List<Integer> ballNumbers) {
		if (ballNumbers.size() != BALL_NUMBER_SIZE) {
			throw new IllegalArgumentException("입력한 수가 3자리 수가 아닙니다");
		}
	}

	private void validateDuplicate(List<Integer> ballNumbers) {
		if (new HashSet<>(ballNumbers).size() < BALL_NUMBER_SIZE) {
			throw new IllegalArgumentException("중복된 숫자를 입력하셨습니다");
		}
	}

	public List<Ball> getBalls() {
		return balls;
	}
}
