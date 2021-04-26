package com.zenic88.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RefereeTest {

	static List<Integer> generatedList = new ArrayList<>();

	@BeforeAll
	static void generate() {
		generatedList.add(1);
		generatedList.add(2);
		generatedList.add(3);
	}

	@Test
	@DisplayName("3 스트라이크인 경우")
	public void threeStrikes() {

		Score score = new Score();
		Referee referee = new Referee();
		for (int i = 0; i < 3; i++) {
			referee.check(score, generatedList, i + 1, i);
		}

		assertThat(score.getStrike()).isEqualTo(3);
		assertThat(score.getBall()).isEqualTo(0);
	}

	@ParameterizedTest
	@MethodSource("provideIntsForTwoStrikes")
	@DisplayName("2 스트라이크인 경우")
	public void twoStrike(int firstUserValue, int first, int secondUserValue, int second, int thirdUserValue,
		int third) {
		Score score = new Score();
		Referee referee = new Referee();
		referee.check(score, generatedList, firstUserValue, first);
		referee.check(score, generatedList, secondUserValue, second);
		referee.check(score, generatedList, thirdUserValue, third);

		assertThat(score.getStrike()).isEqualTo(2);
		assertThat(score.getBall()).isEqualTo(0);
	}

	@ParameterizedTest
	@MethodSource("provideIntsForOneStrikeTwoBall")
	@DisplayName("1 스트라이크 2 볼인 경우")
	public void oneStrikeTwoBall(int firstUserValue, int first, int secondUserValue, int second, int thirdUserValue,
		int third) {
		Score score = new Score();
		Referee referee = new Referee();
		referee.check(score, generatedList, firstUserValue, first);
		referee.check(score, generatedList, secondUserValue, second);
		referee.check(score, generatedList, thirdUserValue, third);

		assertThat(score.getStrike()).isEqualTo(1);
		assertThat(score.getBall()).isEqualTo(2);
	}

	@ParameterizedTest
	@MethodSource("provideIntsForThreeBall")
	@DisplayName("3 볼인 경우")
	public void threeBall(int firstUserValue, int first, int secondUserValue, int second, int thirdUserValue,
		int third) {
		Score score = new Score();
		Referee referee = new Referee();
		referee.check(score, generatedList, firstUserValue, first);
		referee.check(score, generatedList, secondUserValue, second);
		referee.check(score, generatedList, thirdUserValue, third);

		assertThat(score.getStrike()).isEqualTo(0);
		assertThat(score.getBall()).isEqualTo(3);
	}

	private static Stream<Arguments> provideIntsForTwoStrikes() {
		return Stream.of(
			Arguments.of(1, 0, 2, 1, 4, 2),
			Arguments.of(4, 0, 2, 1, 3, 2),
			Arguments.of(1, 0, 4, 1, 3, 2)
		);
	}

	private static Stream<Arguments> provideIntsForOneStrikeTwoBall() {
		return Stream.of(
			Arguments.of(1, 0, 3, 1, 2, 2),
			Arguments.of(3, 0, 2, 1, 1, 2),
			Arguments.of(2, 0, 1, 1, 3, 2)
		);
	}

	private static Stream<Arguments> provideIntsForThreeBall() {
		return Stream.of(
			Arguments.of(3, 0, 1, 1, 2, 2),
			Arguments.of(2, 0, 3, 1, 1, 2)
		);
	}
}
