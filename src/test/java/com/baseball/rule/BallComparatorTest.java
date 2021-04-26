package com.baseball.rule;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallComparatorTest {
	private String inputText;
	private ArrayList<Integer> inputNumbers;

	private ArrayList<Integer> generatedNumbers;

	@BeforeEach
	void setUp() {
		generatedNumbers = new ArrayList<Integer>();
		generatedNumbers.add(4);
		generatedNumbers.add(5);
		generatedNumbers.add(3);
	}

	@ParameterizedTest
	@CsvSource(value = {"f12:true", "f123:false", "1,2,3:false", "1:false", "123:true"}, delimiter = ':')
	@DisplayName("유효성 검증 : 길이 테스")
	public void isProperLengthTest(String inputText, boolean expectedResults) {
		//GIVEN
		BallComparator BallComparator = new BallComparator(inputText, generatedNumbers);

		//WHEN, THEN
		Assertions.assertEquals(BallComparator.isProperLength(), expectedResults);
	}

	@ParameterizedTest
	@CsvSource(value = {"f12:false", "f123:false", "1,2,3:false", "1:true", "123:true"}, delimiter = ':')
	@DisplayName("유효성 검증 : 숫자 형식 테스트")
	public void isNumericTest(String inputText, boolean expectedResults) {
		//GIVEN
		BallComparator BallComparator = new BallComparator(inputText, generatedNumbers);

		//WHEN, THEN
		Assertions.assertEquals(BallComparator.isNumeric(), expectedResults);
	}


}
