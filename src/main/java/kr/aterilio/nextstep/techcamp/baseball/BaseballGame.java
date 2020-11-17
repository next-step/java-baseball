package kr.aterilio.nextstep.techcamp.baseball;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BaseballGame {

	private static final int GAME_SIZE = 3;
	private static final int MAX_GAME_CREATE_TRY = 30;

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	ArrayList<Integer> board = new ArrayList<>();

	public void create() {
		int tryCount = 0;
		LinkedHashSet<Integer> boardSet = new LinkedHashSet<>();
		while(boardSet.size() < GAME_SIZE && tryCount < MAX_GAME_CREATE_TRY) {
			boardSet.add(getRandomNumber());
			tryCount++;
		}
		this.board.addAll(boardSet);
	}

	void create(List<Integer> board) {
		this.board.addAll(board);
	}

	private int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
	}

	public boolean isCreateSuccess() {
		return board != null && board.size() == GAME_SIZE;
	}

	public void printBoard() {
		StringJoiner stringJoiner = new StringJoiner(",");
		for (Integer number : safeList(board)) {
			stringJoiner.add(number.toString());
		}
		System.out.println(stringJoiner.toString());
	}

	private List<Integer> safeList(final List<Integer> board) {
		return board == null ? Collections.emptyList() : board;
	}

	public int getGameSize() {
		return GAME_SIZE;
	}

	public BaseballResult judge(List<Integer> inputs) {
		BaseballResult result = new BaseballResult();
		if (!isCreateSuccess() || board.size() != inputs.size()) {
			result.nothing();
			return result;
		}
		for (int i = 0; i < board.size(); ++i) {
			subJudge(inputs, i, result);
		}
		return result;
	}

	private void subJudge(List<Integer> inputs, int indexBoard, BaseballResult result) {
		for (int i = 0; i < inputs.size(); ++i) {
			unitJudge(inputs, indexBoard, i, result);
		}
	}

	private void unitJudge(List<Integer> inputs, int indexBoard, int indexInput, BaseballResult result) {
		if ( !board.get(indexBoard).equals(inputs.get(indexInput)) ) {
			return;
		}
		if (indexBoard == indexInput) {
			result.strike();
			return;
		}
		result.ball();
	}
}
