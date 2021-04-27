package study;

import java.util.List;
import java.util.Objects;

public class ScoreBoard {
	public Score countScore(List<Integer> swings, List<Integer> pitches) {
		Score result = Score.nothing();
		for (int i = 0; i < 3; i++) {
			Score score = getScore(swings, pitches, i);
			result = result.sumScore(score);
		}
		return result;
	}

	private Score getScore(List<Integer> swings, List<Integer> pitches, int index) {
		if (isStrike(swings.get(index), getPitch(pitches, index))) {
			return Score.strike();
		}
		if (isBall(swings.get(index), pitches, index)) {
			return Score.ball();
		}
		return Score.nothing();
	}

	private boolean isStrike(int swing, int pitch) {
		return Objects.equals(swing, pitch);
	}

	private boolean isBall(int swing, List<Integer> pitches, int index) {
		return Objects.equals(swing, getPitch(pitches, index + 1))
			|| Objects.equals(swing, getPitch(pitches, index + 2));
	}

	private int getPitch(List<Integer> pitches, int index) {
		return pitches.get(index % 3);
	}
}
