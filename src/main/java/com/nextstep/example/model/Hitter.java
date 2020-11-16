package com.nextstep.example.model;

public class Hitter {
	private static final String[] STRIKE_ZONE = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	private StringBuilder pitchPrediction;

	public void predictPitching() {
		pitchPrediction = new StringBuilder();
		while (pitchPrediction.length() < 3) {
			int rdNumb = (int) (Math.random() * 10);
			addPitching(rdNumb);
		}
	}

	private void addPitching(int rdNumb) {
		String target = STRIKE_ZONE[rdNumb];
		if (pitchPrediction.indexOf(target) == -1) {
			pitchPrediction.append(target);
		}
	}

	public String getPitchPrediction() {
		return pitchPrediction.toString();
	}
}
