package com.nextstep.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

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
	void test_ThreeStrike() {
		List<Integer> answerList = Arrays.asList(1, 2, 3);
		assertThat(answerList)
				.isNotNull()
				.isNotEmpty()
				.doesNotContainNull()
				.doesNotHaveDuplicates()
				.hasSize(3).withFailMessage("컴퓨터의 입력값에 오류가 있습니다.");
		for (Integer input : answerList) {
			assertThat(numbersRange.contains(input)).isTrue().withFailMessage("입력 범위에 오류가 있습니다.");
		}

		List<Integer> inputList = Arrays.asList(1, 2, 3);
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

	@Test
	@DisplayName("2 Strike 테스트")
	void test_TwoStrike() {
		List<Boolean> result = baseBall.detectStrike(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 3));
		assertThat(result).isNotNull().isNotEmpty().containsExactly(Boolean.TRUE, Boolean.FALSE, Boolean.TRUE).hasSize(3);
	}

	@Test
	@DisplayName("1 Strike 테스트")
	void test_OneStrike() {
		List<Boolean> result = baseBall.detectStrike(Arrays.asList(1, 2, 3), Arrays.asList(1, 4, 5));
		assertThat(result).isNotNull().isNotEmpty().containsExactly(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE).hasSize(3);
	}

	@Test
	@DisplayName("1 Ball 테스트")
	void test_OneBall() {
		List<Integer> answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);

		List<Integer> inputNumberList = new ArrayList<>();
		inputNumberList.add(4);
		inputNumberList.add(1);
		inputNumberList.add(5);

		List<Boolean> strikeList = new ArrayList<>();
		strikeList.add(false);
		strikeList.add(false);
		strikeList.add(false);

		int ballCount = baseBall.detectBall(strikeList, answerList, inputNumberList);
		assertThat(ballCount).isEqualTo(1);
	}

	@Test
	@DisplayName("2 Ball 테스트")
	void test_TwoBall() {
		List<Integer> answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);

		List<Integer> inputNumberList = new ArrayList<>();
		inputNumberList.add(3);
		inputNumberList.add(1);
		inputNumberList.add(5);

		List<Boolean> strikeList = new ArrayList<>();
		strikeList.add(false);
		strikeList.add(false);
		strikeList.add(false);

		int ballCount = baseBall.detectBall(strikeList, answerList, inputNumberList);
		assertThat(ballCount).isEqualTo(2);
	}

	@Test
	@DisplayName("3 Ball 테스트")
	void test_ThreeBall() {
		List<Integer> answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);

		List<Integer> inputNumberList = new ArrayList<>();
		inputNumberList.add(3);
		inputNumberList.add(1);
		inputNumberList.add(2);

		List<Boolean> strikeList = new ArrayList<>();
		strikeList.add(false);
		strikeList.add(false);
		strikeList.add(false);

		int ballCount = baseBall.detectBall(strikeList, answerList, inputNumberList);
		assertThat(ballCount).isEqualTo(3);
	}

	@Test
	@DisplayName("Nothing 테스트")
	void test_Nothing() {
		List<Integer> answerList = new ArrayList<>();
		answerList.add(1);
		answerList.add(2);
		answerList.add(3);

		List<Integer> inputNumberList = new ArrayList<>();
		inputNumberList.add(5);
		inputNumberList.add(6);
		inputNumberList.add(7);

		List<Boolean> strikeList = new ArrayList<>();
		strikeList.add(false);
		strikeList.add(false);
		strikeList.add(false);

		int ballCount = baseBall.detectBall(strikeList, answerList, inputNumberList);
		boolean isNothing = baseBall.isNothing(answerList, ballCount);
		assertThat(isNothing).isEqualTo(true);
	}
}
