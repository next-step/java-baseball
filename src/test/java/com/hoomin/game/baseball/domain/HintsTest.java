package com.hoomin.game.baseball.domain;

import static org.junit.jupiter.params.provider.Arguments.*;

import static org.assertj.core.api.Assertions.*;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.hoomin.game.baseball.enums.HintState;

public class HintsTest {

	@ParameterizedTest
	@MethodSource("getHintStatesAndHintCount")
	public void getStrikeCount_HaveHintState_GetHintCount(List<HintState> hintStates, Integer strikeCount, Integer ballCount) {
		Hints hints = new Hints();
		for (HintState hintState : hintStates) {
			hints.add(hintState);
		}
		assertThat(hints.getStrikeCount()).isEqualTo(strikeCount);
		assertThat(hints.getBallCount()).isEqualTo(ballCount);
	}

	@Test
	public void add_AddMoreThan3_RuntimeExceptionThrown() {
		Hints hints = new Hints();
		hints.add(HintState.STRIKE);
		hints.add(HintState.STRIKE);
		hints.add(HintState.STRIKE);
		assertThatThrownBy(() -> hints.add(HintState.STRIKE))
			.isInstanceOf(RuntimeException.class);
	}

	private static Stream<Arguments> getHintStatesAndHintCount() {
		return Stream.of(
			arguments(Collections.singletonList(HintState.STRIKE), 1, 0),
			arguments(Arrays.asList(HintState.STRIKE, HintState.STRIKE), 2, 0),
			arguments(Arrays.asList(HintState.STRIKE, HintState.STRIKE, HintState.STRIKE), 3, 0),
			arguments(Arrays.asList(HintState.STRIKE, HintState.BALL), 1, 1),
			arguments(Arrays.asList(HintState.BALL, HintState.BALL), 0, 2),
			arguments(Collections.emptyList(), 0, 0)
		);
	}
}
