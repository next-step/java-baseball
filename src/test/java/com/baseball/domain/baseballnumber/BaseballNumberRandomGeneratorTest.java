package com.baseball.domain.baseballnumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberRandomGeneratorTest {

    @DisplayName("베이스볼 넘버 랜덤값 생성 테스트")
    @Test
    void generate() {
        // when
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberRandomGenerator();
        BaseballNumber baseballNumber = baseballNumberGenerator.generate();

        // then
        assertThat(baseballNumber).isNotNull();
    }


}