package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class Pitcher {
	public static List<Integer> pitch(int numOfPitches) {
		List<Integer> pitches = new ArrayList<>(numOfPitches);
		while (pitches.size() < numOfPitches) {
			nextPitch(pitches);
		}
		return Collections.unmodifiableList(pitches);
	}

	private static void nextPitch(List<Integer> pitches) {
		int pitch = RandomUtils.nextInt(1, 10);
		if (pitches.contains(pitch)) {
			return;
		}
		pitches.add(pitch);
	}
}
