package com.hoomin.game.baseball.domain;

import java.util.ArrayList;
import java.util.List;

import com.hoomin.game.baseball.enums.HintState;

public class Hints {
	List<HintState> hintStateList;

	Hints() {
		this.hintStateList = new ArrayList<>();
	}

	void add(HintState hintState) {
		hintStateList.add(hintState);
	}

	public Integer getStrikeCount() {
		return getCountByHintState(HintState.STRIKE);
	}

	public Integer getBallCount() {
		return getCountByHintState(HintState.BALL);
	}

	private Integer getCountByHintState(HintState hintState) {
		Integer count = 0;
		for (HintState item : hintStateList) {
			if (item.equals(hintState)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		if (getStrikeCount() > 0 && getBallCount() > 0) {
			return getStrikeCount() + " 스트라이크 " + getBallCount() + " 볼";
		}
		if (getStrikeCount() > 0) {
			return getStrikeCount() + " 스트라이크";
		}
		if (getBallCount() > 0) {
			return getBallCount() + " 볼";
		}
		return "낫싱";
	}
}
