package edu.nextstep.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtilTest {

	@Test
	@DisplayName("generateRandomSingleNumber : 1에서 9 사이의 한 숫자를 리턴해야 함")
	void generateRandomSingleNumber_ShouldReturnOneDigit1To9() {
		// given

		// when
		String number = NumberUtil.generateRandomSingleNumber();

		// then
		assertNotNull(number);
		assertTrue(Pattern.matches("^[1-9]$", number));
	}

	@ParameterizedTest
	@DisplayName("generateNonDuplicatedSingleNumber : 주어진 숫자와 중복하지 않는 숫자를 리턴해야 함")
	@ValueSource(strings = {"12345678", "432", "378", "728", "528", "712", "479"})
	void generateNonDuplicatedSingleNumber_ShouldReturnNonDuplicatedWithGivenNumber(String inputNumber) {
		// given
		String existingNumber = inputNumber;

		// when
		String singleNumber = NumberUtil.generateNonDuplicatedSingleNumber(existingNumber);

		// then
		assertNotNull(singleNumber);
		assertFalse(existingNumber.contains(singleNumber));
	}

	@Test
	@DisplayName("generateNonDuplicatedNumber : 모든 숫자가 중복되지 않도록 리턴해야 함")
	void generateNonDuplicatedNumber_ShouldReturnNonDuplicatedNumber() {
		// given
		int numberSize = 9;

		// when
		String number = NumberUtil.generateNonDuplicatedNumber(numberSize);

		// then
		assertNotNull(number);
		assertAll(
			() -> assertEquals(number.length(), numberSize),
			() -> assertFalse(existDuplicatedAlphabet(number))
		);
	}

	boolean existDuplicatedAlphabet(String str) {
		Set<Character> set = new HashSet<>();
		for (char ch : str.toCharArray()) {
			set.add(ch);
		}
		return str.length() != set.size();
	}
}