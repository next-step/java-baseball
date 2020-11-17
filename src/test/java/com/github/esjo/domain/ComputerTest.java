package com.github.esjo.domain;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.esjo.NumberGenerator;

import static com.github.esjo.domain.Rule.*;
import static org.assertj.core.api.Assertions.*;

class ComputerTest {

    NumberGenerator numberGenerator;

    @BeforeEach
    void setValue() {
        numberGenerator = NumberGenerator.createNumberGenerator(MIN.getValue(), MAX.getValue(),
                NUMBER_OF_DIGITS.getValue());
        assertThat(numberGenerator).as("NumberGenerator 객체 생성").isNotNull();
    }

    @Test
    @DisplayName("중복없는 3자리 정수 생성 테스트")
    void testCreateNumberSet() {
        Computer computer = Computer.createNumberSet(numberGenerator);
        Set<Integer> set = computer.getNumberSet();
        assertThat(computer).as("Computer 객체 생성").isNotNull();
        assertThat(set).as("중복없이 3자리 정수 생성").hasSize(3);
    }

}

