package com.hoomin.game.baseball.domain;

import java.util.ArrayList;
import java.util.List;

import com.hoomin.game.baseball.enums.HintState;

/**
 * 힌트 자료구조
 * hintStates는 불변
 */
public class Hints {
	private final List<HintState> hintStates;

	protected Hints() {
		this.hintStates = new ArrayList<>();
	}

	public void add(HintState hintState) {
		validateHintsSize();
		hintStates.add(hintState);
	}

	public int getStrikeCount() {
		return getCountByHintState(HintState.STRIKE);
	}

	public int getBallCount() {
		return getCountByHintState(HintState.BALL);
	}

	private int getCountByHintState(HintState anotherHintState) {
		int count = 0;
		for (HintState item : hintStates) {
			count = increaseCountIfEquals(anotherHintState, item, count);
		}
		return count;
	}

	private void validateHintsSize() {
		if (hintStates.size() >= 3) {
			throw new RuntimeException("한 질문에 힌트가 3개를 넘을 수 없습니다.");
		}
	}

	private int increaseCountIfEquals(HintState anotherHintState, HintState  hintState, int count) {
		if (hintState.equals(anotherHintState)) {
			count++;
		}
		return count;
	}
}