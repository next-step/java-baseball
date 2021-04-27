package com.hoomin.game.baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumbersTest {

	@ParameterizedTest
	@CsvSource(value = {"1234:3자리의 숫자를 입력해야 합니다.",
			"012:1부터 9까지의 숫자를 입력해야 합니다.",
			"112:중복되지 않은 숫자를 입력해야 합니다."}, delimiter = ':')
	public void newNumbers_InvalidNumber_IllegalArgumentException(String numberString, String message) {
		final List<Integer> numberCandidates = createNumberCandidates(numberString);
		assertThatThrownBy(() -> new Numbers(numberCandidates))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(message);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:123:3:0", "123:124:2:0", "123:132:1:2", "321:314:1:1", "123:312:0:3",
			"123:314:0:2", "123:345:0:1", "123:456:0:0"}, delimiter = ':')
	public void compareNumbers_ValidNumber_GetRightHints(String rightNumberString, String inputNumberString, Integer strikeCount, Integer ballCount) {
		final Numbers rightNumbers = new Numbers(createNumberCandidates(rightNumberString));
		final Numbers inputNumbers = new Numbers(createNumberCandidates(inputNumberString));
		final Hints hints = rightNumbers.compareTo(inputNumbers);
		assertThat(hints.getStrikeCount()).isEqualTo(strikeCount);
		assertThat(hints.getBallCount()).isEqualTo(ballCount);
	}

	private List<Integer> createNumberCandidates(String numberString) {
		final String[] split = numberString.split("");
		final List<Integer> numberCandidates = new ArrayList<>();
		for (String s : split) {
			numberCandidates.add(Integer.valueOf(s));
		}
		return numberCandidates;
	}
}
