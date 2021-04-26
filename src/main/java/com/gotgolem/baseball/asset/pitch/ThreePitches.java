package com.gotgolem.baseball.asset.pitch;

import java.util.Collections;
import java.util.List;

public class ThreePitches {

	private final List<Ball> pitches;

	public ThreePitches(List<Ball> pitches) {
		this.pitches = Collections.unmodifiableList(pitches);
	}

	public Ball getFirst() {
		return pitches.get(0);
	}

	public Ball getSecond() {
		return pitches.get(1);
	}

	public Ball getThird() {
		return pitches.get(2);
	}

	public boolean contains(Ball ball) {
		return pitches.contains(ball);
	}

}
