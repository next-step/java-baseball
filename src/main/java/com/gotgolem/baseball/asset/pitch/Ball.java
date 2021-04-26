package com.gotgolem.baseball.asset.pitch;

public enum Ball {

	FAST,
	BREAKING,
	CHANGE_UP,
	KNUCKLE,
	FORK,
	SINKER,
	CURVE,
	SCREW,
	SLIDE;

	public static Ball toBall(int ballNumber) {
		return values()[ballNumber - 1];
	}

}
