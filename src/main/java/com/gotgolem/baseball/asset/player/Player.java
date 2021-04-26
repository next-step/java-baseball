package com.gotgolem.baseball.asset.player;

import com.gotgolem.baseball.asset.pitch.ThreePitches;

public class Player {

	private ThreePitches pitches;

	public void changePitches(ThreePitches pitches) {
		this.pitches = pitches;
	}

	public ThreePitches getPitches() {
		return pitches;
	}

}
