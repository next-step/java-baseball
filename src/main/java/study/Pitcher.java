package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class Pitcher {
	public List<Integer> pitch(int numOfPitches) {
		List<Integer> pitches = new ArrayList<>(3);
		while (pitches.size() < 3) {
			nextPitch(pitches);
		}
		return Collections.unmodifiableList(pitches);
	}

	private void nextPitch(List<Integer> pitches) {
		int pitch = RandomUtils.nextInt(1, 10);
		if (pitches.contains(pitch)) {
			return;
		}
		pitches.add(pitch);
	}
}
