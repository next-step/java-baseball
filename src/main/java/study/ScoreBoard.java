package study;

import java.util.List;
import java.util.Objects;

public class ScoreBoard {
	public Score countScore(List<Integer> pitches, List<Integer> swings) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			strike += isStrike(pitches, swings, i);
		}
		return new Score(strike, 0);
	}

	private int isStrike(List<Integer> pitches, List<Integer> swings, int index) {
		if (Objects.equals(swings.get(index), pitches.get(index))) {
			return 1;
		}
		return 0;
	}
}
