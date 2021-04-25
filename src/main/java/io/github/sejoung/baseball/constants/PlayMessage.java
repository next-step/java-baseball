package io.github.sejoung.baseball.constants;

public class PlayMessage {
	private static final String STRIKE = "%d 스트라이크";

	public static String getStrike(int count) {
		return String.format(STRIKE, count);
	}
}
