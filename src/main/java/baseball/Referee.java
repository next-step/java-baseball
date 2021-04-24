package baseball;

// TODO: Add UI Decorate
public class Referee {

	public Referee() {
	}

	private int isSame(int left, int right) {
		return left == right ? 1 : 0;
	}

	public int countStrikes(int[] player, int[] opponent) {
		int count = 0;

		for (int i = 0; i < 3; i++) {
			count += isSame(player[i], opponent[i]);
		}

		return count;
	}

	public int countBall(int[] player, int[] opponent) {
		int count = 0;

		for (int i = 0; i < 3; i++) {
			int[] cmp = {player[i], player[i], player[i]};
			cmp[i] = 0;
			count += countStrikes(cmp, opponent);
		}

		return count;
	}

	public boolean isAnswer(int strikes) {
		return strikes == 3;
	}

	public boolean isNothing(int strikes, int ball) {
		return strikes == 0 && ball == 0;
	}
}
