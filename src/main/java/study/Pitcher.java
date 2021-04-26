package study;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;

public class Pitcher {
	public Set<Integer> pitch(int numOfPitches) {
		Set<Integer> pitches = new HashSet<>();
		while (pitches.size() < 3) {
			pitches.add(RandomUtils.nextInt(1, 10));
		}
		return pitches;
	}
}
