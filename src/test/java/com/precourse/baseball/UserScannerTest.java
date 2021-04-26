package com.precourse.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserScannerTest {
	private final UserScanner userScanner = new UserScanner();

	@Test
	@DisplayName("char형 문자 int형으로 변환")
	public void testCharToInt() {
		char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		for (int i = 0; i < numbers.length; i++) {
			int number = userScanner.charToInt(numbers[i]);
			assertThat(number).isEqualTo(i);
		}
	}

	@Test
	@DisplayName("문자열을 리스트로 반환")
	public void testGenerateList() {
		String str = "987";
		List<Integer> numbers = userScanner.generateList(str);
		System.out.println(numbers);
		assertThat(numbers).containsExactly(9, 8, 7);
	}
}
