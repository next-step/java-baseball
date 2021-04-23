package me.right42.domain;

import java.util.EnumMap;
import java.util.Map;

import me.right42.domain.type.BallMatchType;

public class BallMatchResult {

	private final Map<BallMatchType, Integer> match;

	private static final Integer ALL_STRIKE_COUNT = 3;

	public BallMatchResult() {
		match = new EnumMap<>(BallMatchType.class);
		match.put(BallMatchType.BALL, 0);
		match.put(BallMatchType.STRIKE, 0);
		match.put(BallMatchType.NOTHING, 0);
	}

	public boolean isAllStrike() {
		return this.match.get(BallMatchType.STRIKE).equals(ALL_STRIKE_COUNT);
	}

	public void addCount(BallMatchType ballMatchType) {
		this.match.put(ballMatchType, this.match.get(ballMatchType) + 1);
	}

	public void printMatchInfo() {
		Integer strikeCount = match.get(BallMatchType.STRIKE);
		Integer ballCount = match.get(BallMatchType.BALL);

		if (strikeCount > 0) {
			System.out.printf("%d 스트라이크 ", strikeCount);
		}

		if (ballCount > 0) {
			System.out.printf("%d 볼", ballCount);
		}

		if (ballCount == 0 && strikeCount == 0) {
			System.out.print("낫싱");
		}

		System.out.println();
	}

}