package com.nextstep.example.model;

public class Referee {
	private int ballCount;
	private int strikeCount;

	public boolean getJudge(String hitterPrediction, String pitcherPrediction) {
		init();
		for (int i = 0; i < pitcherPrediction.length(); i++) {
			String pitching = pitcherPrediction.substring(i, i + 1);
			compare(hitterPrediction, pitching, i);
		}
		String score = getScore();
		System.out.println(score);

		return strikeCount == 3;
	}

	private void init() {
		ballCount = 0;
		strikeCount = 0;
	}

	private String getScore() {
		StringBuilder sb = new StringBuilder();
		appendScore(sb, strikeCount, "스트라이크");
		appendScore(sb, ballCount, "볼");
		return sb.length() > 0 ? sb.toString() : "낫싱";
	}

	private void appendScore(StringBuilder sb, int count, String typeName) {
		if (sb.length() > 0) {
			sb.append(" ");
		}
		if (count > 0) {
			sb.append(count).append(" ").append(typeName);
		}
	}

	private void compare(String hitterPrediction, String pitching, int idx) {
		String hitting = hitterPrediction.substring(idx, idx + 1);
		boolean isStrike = checkStrike(hitting, pitching);
		if (!isStrike) {
			checkBall(hitterPrediction, pitching);
		}
	}

	private boolean checkStrike(String hitting, String pitching) {
		if (hitting.equals(pitching)) {
			strikeCount++;
			return true;
		}
		return false;
	}

	private boolean checkBall(String hitterPrediction, String pitching) {
		if (hitterPrediction.contains(pitching)) {
			ballCount++;
			return true;
		}
		return false;
	}
}
