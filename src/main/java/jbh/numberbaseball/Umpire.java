package jbh.numberbaseball;

import java.util.HashMap;
import java.util.Map;

import jbh.utils.BallUtil;

public class Umpire {

	private static final String STRIKE = "STRIKE";
	private static final String BALL = "BALL";

	public GameResult judgePitching(String defenceBall, String userBall) {
		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < userBall.length(); i++) {
			addPitchingCount(defenceBall, userBall.charAt(i), i, count);
		}
		return new GameResult(count.getOrDefault(STRIKE, 0), count.getOrDefault(BALL, 0));
	}

	private void addPitchingCount(String numbersText, char numberChar, int index,
		Map<String, Integer> pitchingCount) {
		if (isStrike(numbersText, numberChar, index)) {
			pitchingCount.put(STRIKE, pitchingCount.getOrDefault(STRIKE, 0) + 1);
		}
		if (isBall(numbersText, numberChar, index)) {
			pitchingCount.put(BALL, pitchingCount.getOrDefault(BALL, 0) + 1);
		}
	}

	private boolean isStrike(String numbersText, char numberChar, int index) {
		return numbersText.charAt(index) == numberChar;
	}

	private boolean isBall(String numbersText, char numberChar, int index) {
		return BallUtil.containCharInText(numberChar, numbersText) && numbersText.charAt(index) != numberChar;
	}
}
