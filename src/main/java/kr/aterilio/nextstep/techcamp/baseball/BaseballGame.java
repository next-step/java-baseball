package kr.aterilio.nextstep.techcamp.baseball;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballGame {

	private static final int GAME_SIZE = 3;
	private static final int MAX_GAME_CREATE_TRY = 30;

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	LinkedHashSet<Integer> board;

	public void create() {
		int tryCount = 0;
		board = new LinkedHashSet<>();
		while(board.size() < GAME_SIZE && tryCount < MAX_GAME_CREATE_TRY) {
			board.add(getRandomNumber());
			tryCount++;
		}
	}

	private int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
	}

	public boolean isCreateSuccess() {
		return board != null && board.size() == GAME_SIZE;
	}

	public void printBoard() {
		StringJoiner stringJoiner = new StringJoiner(",");
		for (Integer number : safeSet(board)) {
			stringJoiner.add(number.toString());
		}
		System.out.println(stringJoiner.toString());
	}

	private Set<Integer> safeSet(final Set<Integer> board) {
		return board == null ? Collections.emptySet() : board;
	}

	public int getGameSize() {
		return GAME_SIZE;
	}
}
