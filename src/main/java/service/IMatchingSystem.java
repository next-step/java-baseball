package service;

import java.util.Map;

import dto.BallCount;

public interface IMatchingSystem {
	BallCount match(final Map<Integer, Integer> computerNumber, final int[] playerNumber);
}
