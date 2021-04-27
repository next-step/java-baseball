package com.hoomin.game.baseball.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 정답을 만드는 주체
 */
public class Computer {
	public Numbers makeRightNumbers() {
		final List<Integer> subNumberCandidates = generateIntegers();
		return new Numbers(subNumberCandidates);
	}

	protected List<Integer> generateIntegers() {
		final List<Integer> numberCandidates = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(numberCandidates);
		return numberCandidates.subList(0, 3);
	}
}
