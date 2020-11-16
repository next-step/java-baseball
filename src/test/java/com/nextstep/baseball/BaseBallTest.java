package com.nextstep.baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseBallTest {
	private Set<Integer> numbersRange;

	BaseBall baseBall = new BaseBall();

	@BeforeEach
	void setUp() {
		numbersRange = new HashSet<>();
		for (int i = 1; i < 10; i++) {
			numbersRange.add(i);
		}
	}

	/*
	1. 1~9까지 서로 다른 임의의 수 3개를 선택하여 리턴하는 기능
	2. 사용자로부터 1~9까지 서로 다른 임의의 수 3개를 입력 받는 기능
	3. Strike, Ball, Nothing 체크하는 기능
        - 3 Strike가 나올때까지 반복해야함.
	4. 결과 출력
	5. 게임 재시작 또는 종료 기능
	 */

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

	@Test
	@DisplayName("3 Strike 테스트")
	void test_ThreeStrike(){
		List<Integer> answerList = Arrays.asList(1,2,3);
		assertThat(answerList)
				.isNotNull()
				.isNotEmpty()
				.doesNotContainNull()
				.doesNotHaveDuplicates()
				.hasSize(3).withFailMessage("컴퓨터의 입력값에 오류가 있습니다.");
		for (Integer input : answerList) {
			assertThat(numbersRange.contains(input)).isTrue().withFailMessage("입력 범위에 오류가 있습니다.");
		}

		List<Integer> inputList = Arrays.asList(1,2,3);
		assertThat(inputList)
				.isNotNull()
				.isNotEmpty()
				.doesNotContainNull()
				.doesNotHaveDuplicates()
				.hasSize(3).withFailMessage("사용자의 입력값에 오류가 있습니다.");
		for (Integer input : inputList) {
			assertThat(numbersRange.contains(input)).isTrue().withFailMessage("입력 범위에 오류가 있습니다.");
		}

		List<Boolean> result = baseBall.detectStrike(answerList, inputList);
		assertThat(result).isNotNull().isNotEmpty().containsExactly(Boolean.TRUE, Boolean.TRUE, Boolean.TRUE).hasSize(3);
	}

}
