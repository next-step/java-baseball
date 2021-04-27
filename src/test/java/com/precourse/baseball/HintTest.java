package com.precourse.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HintTest {
	private final List<Integer> com = new ArrayList<>(Arrays.asList(1, 2, 3));
	private final List<Integer> user1 = new ArrayList<>(Arrays.asList(1, 2, 3));
	private final List<Integer> user2 = new ArrayList<>(Arrays.asList(3, 2, 1));
	private final List<Integer> user3 = new ArrayList<>(Arrays.asList(6, 9, 7));
	private final List<Integer> user4 = new ArrayList<>(Arrays.asList(3, 1, 2));
	private final Hint hint1 = new Hint(com, user1);
	private final Hint hint2 = new Hint(com, user2);
	private final Hint hint3 = new Hint(com, user3);
	private final Hint hint4 = new Hint(com, user4);

	public HintTest() {
	}

	@Test
	@DisplayName("인덱스와 값이 모두 일치하는 갯수 반환")
	public void testCountStrike() {
		assertThat(hint1.countStrike()).isEqualTo(3);
		assertThat(hint2.countStrike()).isEqualTo(1);
		assertThat(hint3.countStrike()).isEqualTo(0);
		assertThat(hint4.countStrike()).isEqualTo(0);
	}

	@Test
	@DisplayName("인덱스는 일치하지 않아야 하고 값만 일치하는 갯수를 반환")
	public void testCountBall() {
		assertThat(hint1.countBall()).isEqualTo(0);
		assertThat(hint2.countBall()).isEqualTo(2);
		assertThat(hint3.countBall()).isEqualTo(0);
		assertThat(hint4.countBall()).isEqualTo(3);
	}

	@Test
	@DisplayName("힌트 문자열 반환")
	public void testGetHint() {
		assertThat(hint1.getHint()).isEqualTo("3 스트라이크");
		assertThat(hint2.getHint()).isEqualTo("1 스트라이크 2볼");
		assertThat(hint3.getHint()).isEqualTo("포볼");
		assertThat(hint4.getHint()).isEqualTo("3볼");
	}
}
