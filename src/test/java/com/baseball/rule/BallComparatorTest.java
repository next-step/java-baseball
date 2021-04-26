package com.baseball.rule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallComparatorTest {
	ArrayList<Integer> generatedNumbers;
	ArrayList<Integer> inputNumbers;

	@BeforeEach
	void setUp() {
		generatedNumbers = new ArrayList<>();
		generatedNumbers.add(4);
		generatedNumbers.add(5);
		generatedNumbers.add(3);

		inputNumbers = new ArrayList<>();
		inputNumbers.add(3);
		inputNumbers.add(5);
		inputNumbers.add(4);
	}

	@Test
	@DisplayName("입력값 판단 스트라이크, 볼 판단 테스트")
	public void compareNumbersTest(){
		//wHEN
		BallComparator ballComparator = new BallComparator(generatedNumbers, inputNumbers);
		ballComparator.compareNumbers();

		//THEN
		Assertions.assertEquals(ballComparator.getStrike(), 1);
		Assertions.assertEquals(ballComparator.getBall(), 2);
	}

}
