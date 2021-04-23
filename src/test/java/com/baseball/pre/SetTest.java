package com.baseball.pre;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}
	// Test Case 구현

	@Test
	@DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
	public void sizeTest(){
		//GIVEN
		int size = numbers.size();

		//THEN
		assertEquals(size, 3);
	}

	// @Test
	// void contains(){
	// 	assertThat(numbers.contains(1)).isTrue();
	// 	assertThat(numbers.contains(2)).isTrue();
	// 	assertThat(numbers.contains(3)).isTrue();
	// }

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	@DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
	public void contains(int input) {
		//WHEN
		boolean contains = numbers.contains(input);

		//THEN
		assertThat(contains).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
	@DisplayName("입력값에 따라 결과가 다를 시 테스트")
	public void contains(int input, boolean expected) {
		//WHEN
		boolean contains = numbers.contains(input);

		//THEN
		assertEquals(contains, expected);
	}
}
