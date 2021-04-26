package com.gotgolem.baseball.asset.pitch;

import java.util.Collections;
import java.util.List;

public class ThreePitches {

	private final List<Ball> pitches;

	public ThreePitches(List<Ball> pitches) {
		this.pitches = Collections.unmodifiableList(pitches);
	}

}
