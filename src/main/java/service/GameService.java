package service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameService {

	private List<Integer> balls;

	public GameService() {
		this.balls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	public List<Integer> generate() {
		Collections.shuffle(balls);
		return Arrays.asList(balls.get(0), balls.get(1), balls.get(2));
	}
}
