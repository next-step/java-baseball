package baseball;

public class BallCountStrikeResolver implements BallCountResolver {
	@Override
	public boolean isMatch(final int index, final String input, final String answer) {
		char inputChar = input.charAt(index);
		char answerChar =answer.charAt(index);
		return (inputChar == answerChar) ? true : false;
	}

	@Override
	public void resolve(BallCount ballCounts) {
		ballCounts.addStrike();
	}
}
