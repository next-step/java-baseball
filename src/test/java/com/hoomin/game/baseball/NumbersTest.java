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
		final List<Integer> numberList = Arrays.asList(1, 2, 3, 4);
		assertThatThrownBy(() -> new Numbers(numberList))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("3자리의 숫자를 입력해야 합니다.");
	}

	@Test
	public void newNumbers_IncludeNumberZero_IllegalArgumentException() {
		final List<Integer> numberCandidateList = Arrays.asList(0, 1, 2);
		assertThatThrownBy(() -> new Numbers(numberCandidateList))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("1부터 9까지의 숫자를 입력해야 합니다.");
	}

}
