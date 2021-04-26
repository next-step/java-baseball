package com.precourse.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlaygroundTest {
	private final Playground playground = new Playground();

	@Test
	@DisplayName("두개의 리스트가 같으면 true 반환")
	public void testIsOut() {
		List<Integer> com = new ArrayList<>(Arrays.asList(9, 8, 7));
		List<Integer> user = new ArrayList<>(Arrays.asList(9, 8, 7));
		boolean out = playground.isOut(com, user);
		assertThat(out).isTrue();
	}

	@Test
	@DisplayName("두개의 리스트가 다르면 false 반환")
	public void testIsNoOut() {
		List<Integer> com = new ArrayList<>(Arrays.asList(1, 2, 3));
		List<Integer> user = new ArrayList<>(Arrays.asList(1, 2, 4));
		boolean out = playground.isOut(com, user);
		assertThat(out).isFalse();
	}
}
