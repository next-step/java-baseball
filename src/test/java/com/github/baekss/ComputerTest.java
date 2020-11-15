package com.github.baekss;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.baekss.domain.Computer;

public class ComputerTest {
	
	private Computer computer;
	
	@BeforeEach
	public void createComputer() {
		this.computer = Computer.createComputer(3, 1, 9);
	}
	
	@Test
	@DisplayName("서로다른 임의의 숫자 3개 조합 테스트")
	public void createComputerTest() {
		Set<Integer> threeDigitNumberSet = computer.getThreeDigitNumberSet();
		assertThat(threeDigitNumberSet.size()).isEqualTo(3);
	}
	
	@Test
	@DisplayName("플레이어 입력값과 컴퓨터의 숫자 비교 테스트")
	public void inputNumberVersusComputerNumberTest() {
		Set<Integer> inputNumberSet = new LinkedHashSet<>();
		inputNumberSet.add(5);
		inputNumberSet.add(4);
		inputNumberSet.add(7);
		boolean flag = computer.compareInputNumberToComputerNumbers(inputNumberSet);
		assertThat(flag).isFalse();
		
		computer.setThreeDigitNumberSet(inputNumberSet);
		flag = computer.compareInputNumberToComputerNumbers(inputNumberSet);
		assertThat(flag).isTrue();
	}
}
