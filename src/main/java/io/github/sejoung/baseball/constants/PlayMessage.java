package io.github.sejoung.baseball.constants;

public class PlayMessage {
	private static final String STRIKE = "%d 스트라이크";
	private static final String BALL = "%d 볼";
	public static final String NOTHING = "낫싱";

	public static String getStrike(int count) {
		return String.format(STRIKE, count);
	}

	public static String getBall(int count){
		return String.format(BALL, count);
	}
}
