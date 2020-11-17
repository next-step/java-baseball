package com.hoomin.game.baseball;

import com.hoomin.game.baseball.domain.Numbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {

	@ParameterizedTest
	@CsvSource(value = {"1234:3자리의 숫자를 입력해야 합니다.",
			"012:1부터 9까지의 숫자를 입력해야 합니다.",
			"112:중복되지 않은 숫자를 입력해야 합니다."}, delimiter = ':')
	public void newNumbers_NotValidNumber_IllegalArgumentException(String numberString, String message) {
		final String[] split = numberString.split("");
		final List<Integer> numberCandidateList = new ArrayList<>();
		for (String s : split) {
			numberCandidateList.add(Integer.valueOf(s));
		}
		assertThatThrownBy(() -> new Numbers(numberCandidateList))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage(message);
	}
	
	
}
