package com.github.baekss;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.baekss.domain.Computer;

public class ComputerTest {
	
	@Test
	@DisplayName("서로다른 임의의 숫자 3개 조합 테스트")
	public void createComputerTest() {
		Computer computer = Computer.createComputer(3, 1, 9);
		
		Set<Integer> threeDigitNumberSet = computer.getThreeDigitNumberSet();
		assertThat(threeDigitNumberSet.size()).isEqualTo(3);
	}
}
