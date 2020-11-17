package com.hoomin.game.baseball.domain;

import java.util.ArrayList;
import java.util.List;

import com.hoomin.game.baseball.enums.HintState;

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

	/**
	 * 10줄 넘어가는데 단일책임원칙은 만족하는거 같은데..
	 * final Integer strikeCount = getStrikeCount();
	 * final Integer ballCount = getBallCount();
	 * if (strikeCount > 0 && ballCount > 0) {
	 * 	return strikeCount + " 스트라이크 " + ballCount + " 볼";
	 *           }
	 * if (strikeCount > 0) {
	 * 	return strikeCount + " 스트라이크";
	 *   }
	 * if (ballCount > 0) {
	 * 	return ballCount + " 볼";
	 *   }
	 * return "낫싱";
	 *
	 *
	 */
	@Override
	public String toString() {
		final Integer strikeCount = getStrikeCount();
		final Integer ballCount = getBallCount();
		if (strikeCount.equals(0) && ballCount.equals(0)) {
			return "낫싱";
		}
		StringBuilder builder = new StringBuilder();
		getStrikeAndBallMessage(builder, strikeCount, " 스트라이크 ");
		getStrikeAndBallMessage(builder, ballCount, " 볼");
		return builder.toString().trim();
	}

	private void getStrikeAndBallMessage(StringBuilder builder, Integer count, String message) {
		if (count > 0) {
			builder.append(count).append(message);
		}
	}
}
