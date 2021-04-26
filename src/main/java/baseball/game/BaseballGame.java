package baseball.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballGame implements Game {

	private String pitcherNum;

	public static final int MAX_NUM_SIZE = 3;

	public BaseballGame() {
		this.pitcherNum = generateNum(MAX_NUM_SIZE);
	}

	public void play() {

	}

	private String generateNum(int size) {
		Set<String> result = new HashSet<>();
		while (result.size() < size) {
			result.add(Integer.toString(generateRandNum()));
		}
		return setToStr(result);
	}

	private int generateRandNum() {
		int MIN_NUMBER = 1;
		int MAX_NUMBER = 9;
		return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER);
	}

	private String setToStr(Set<String> set) {
		List<String> result = new ArrayList<>(set);
		Collections.shuffle(result);
		return String.join("", result);
	}
}
