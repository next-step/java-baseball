package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Referee {

	private static final int STRIKEOUT = Deck.SIZE;

	private static int count(int left, int right) {
		return left == right ? 1 : 0;
	}

	public static int countEquals(Iterator<Integer> left, Iterator<Integer> right) {
		int sum = 0;
		while (left.hasNext() && right.hasNext()) {
			sum += count(left.next(), right.next());
		}
		return sum;
	}

	public static int countStrikes(Deck player, Deck opponent) {
		return countEquals(player.numbers().iterator(), opponent.numbers().iterator());
	}

	public static int countBalls(Deck player, Deck opponent) {
		int sum = 0;
		for (int i = 0; i < Deck.SIZE; i++) {
			int value = player.numbers().get(i);
			List<Integer> left = new ArrayList<>(Arrays.asList(value, value, value));
			left.set(i, 0);
			sum += countEquals(left.iterator(), opponent.numbers().iterator());
		}
		return sum;
	}

	public static boolean isAnswer(int strikes) {
		return strikes == STRIKEOUT;
	}

	public static boolean isNothing(int strikes, int ball) {
		return strikes == 0 && ball == 0;
	}

}
