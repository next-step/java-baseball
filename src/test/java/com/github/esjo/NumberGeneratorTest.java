package com.github.esjo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class NumberGeneratorTest {

    @ParameterizedTest(name = "{index} => min={0}, max={1}")
    @CsvSource({
            "1, 9",
            "1, 9",
            "-1, 1000"
    })
    @DisplayName("min이상 max이하의 정수 리턴")
    public void testGenerateRandomNumber(int min, int max) {
        NumberGenerator numberGenerator = NumberGenerator.createNumberGenerator(min, max, 0);

        assertThat(numberGenerator).as("객체 null여부 확인").isNotNull();
        assertThat(numberGenerator.generateRandomNumber())
                .as(min + "이상 " + max + "이하의 정수 리턴")
                .isInstanceOf(Integer.class)
                .isBetween(min, max);
    }
}
