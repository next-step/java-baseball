package io.chikeem90.github.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

class RandomNumberGeneratorTest {
	@Test
	@DisplayName("3자리 숫자 생성 테스트")
	public void generateNumberTest() {
		NumberGenerator numberGenerator = new RandomNumberGenerator();
		List<Character> generatedNumber = numberGenerator.generateNumber();
		assertThat(generatedNumber.size()).isEqualTo(3);
	}
}
