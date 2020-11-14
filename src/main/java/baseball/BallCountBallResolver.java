package baseball;

public class BallCountBallResolver implements BallCountResolver {
	@Override
	public boolean isMatch(int index, String input, String answer) {
		final char inputChar = input.charAt(index);
		return answer.contains(Character.toString(inputChar));
	}

	@Override
	public void resolve(BallCount ballCounts) {
		ballCounts.addBall();
	}
}
