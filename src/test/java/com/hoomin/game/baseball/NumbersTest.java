package com.hoomin.game.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.hoomin.game.baseball.domain.Numbers;

public class NumbersTest {
	@Test
	public void newNumbers_3MoreList_IllegalArgumentException() {
		final List<Integer> numberCandidateList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(numberCandidateList);
		final List<Integer> subNumberCandidateList = numberCandidateList.subList(0, 4);
		assertThatThrownBy(() -> new Numbers(subNumberCandidateList))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("3자리의 숫자를 입력해야 합니다.");
		;
	}
}
