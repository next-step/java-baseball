package baseball;

public interface BallCountResolver {
	boolean isMatch(final int index, final String input, final String answer);

	void resolve(final BallCount ballCounts);
}
