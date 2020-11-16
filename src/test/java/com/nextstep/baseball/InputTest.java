package com.nextstep.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {
	private Set<Integer> numbersRange;

	BaseBall baseBall = new BaseBall();

	@BeforeEach
	void setUp() {
		numbersRange = new HashSet<>();
		for (int i = 1; i < 10; i++) {
			numbersRange.add(i);
		}
	}

	@Test
	@DisplayName("1~9까지 서로 다른 임의의 수 3개를 선택하여 리턴하는 함수 테스트")
	void isNotDuplicatedThreeNumber_Between1To9() {
		List<Integer> selectedThreeNumber = baseBall.selectNonoverlapThreeNumber();

		assertThat(selectedThreeNumber)
				.isNotNull()
				.isNotEmpty()
				.doesNotContainNull()
				.doesNotHaveDuplicates()
				.hasSize(3);

		for (Integer input : selectedThreeNumber) {
			assertThat(numbersRange.contains(input)).isTrue();
		}
	}

	@Test
	@DisplayName("사용자로부터 1~9까지 서로 다른 임의의 수 3개를 입력 받는 함수 테스트")
	void readDigitList() {
		List<Integer> result = baseBall.readNonoverThreeNumber(123);
		assertThat(result)
				.isNotNull()
				.isNotEmpty()
				.doesNotContainNull()
				.doesNotHaveDuplicates()
				.hasSize(3);
		for (Integer input : result) {
			assertThat(numbersRange.contains(input)).isTrue();
		}
	}
}
