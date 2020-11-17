package com.hoomin.game.baseball.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 정답을 만드는 주체
 */
public class Computer {
	public Numbers makeRightNumbers() {
		final List<Integer> subNumberCandidateList = generateNumberList();
		return new Numbers(subNumberCandidateList);
	}

	protected List<Integer> generateNumberList() {
		final List<Integer> numberCandidateList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(numberCandidateList);
		return numberCandidateList.subList(0, 3);
	}
}
