package baseball;

public class Referee {

	public Referee() {

	}

	public boolean isAnswer(int[] player, int[] opponent) {
		return player == opponent;
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

	public boolean isNothing(int strikes, int ball) {
		return strikes == 0 && ball == 0;
	}
}
