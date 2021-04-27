package com.hoomin.game.baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.hoomin.game.baseball.enums.HintState;
import com.hoomin.game.baseball.view.OutputView;

/**
 * 힌트 자료구조
 * hintStateList는 불변
 */
public class Hints {
	private final List<HintState> hintStateList;

	Hints() {
		this.hintStateList = new ArrayList<>();
	}

	public void add(HintState hintState) {
		hintStateList.add(hintState);
	}

	public Integer getStrikeCount() {
		return getCountByHintState(HintState.STRIKE);
	}

	public Integer getBallCount() {
		return getCountByHintState(HintState.BALL);
	}

	private Integer getCountByHintState(HintState anotherHintState) {
		Integer count = 0;
		for (HintState item : hintStateList) {
			count = increaseCountIfEquals(anotherHintState, item, count);
		}
		return count;
	}

	private Integer increaseCountIfEquals(HintState anotherHintState, HintState  hintState, Integer count) {
		if (hintState.equals(anotherHintState)) {
			count++;
		}
		return count;
	}
}