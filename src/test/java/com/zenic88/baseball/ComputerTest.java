package com.zenic88.baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

	static List<Integer> generatedList = new ArrayList<>();

	@BeforeAll
	static void generate() {
		Computer computer = new Computer();
		generatedList = computer.generate();
	}

	@Test
	@DisplayName("생성된 리스트의 크기가 3인지 확인")
	public void generatedListSizeIsThree() {

		assertThat(generatedList.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("중복되지 않은 3자리인지 확인")
	public void generatedListIsNotRedundant() {
		int firstNumber = generatedList.get(0);
		int secondNumber = generatedList.get(1);
		int thirdNumber = generatedList.get(2);

		assertThat(firstNumber).isNotEqualTo(secondNumber);
		assertThat(secondNumber).isNotEqualTo(thirdNumber);
		assertThat(thirdNumber).isNotEqualTo(firstNumber);
	}
}
