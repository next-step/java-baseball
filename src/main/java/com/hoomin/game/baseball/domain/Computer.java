package com.hoomin.game.baseball.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer {
	public Numbers makeRightAnswer() {
		final List<Integer> numberCandidateList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(numberCandidateList);
		return new Numbers(numberCandidateList.subList(0, 3));
	}
}
