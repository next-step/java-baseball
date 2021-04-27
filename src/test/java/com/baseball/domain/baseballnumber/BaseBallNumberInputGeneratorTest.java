package com.baseball.domain.baseballnumber;

import com.baseball.util.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallNumberInputGeneratorTest {

    @DisplayName("베이스볼 넘버 입력값 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "567", "169", "852"})
    void generate(String rawData) {
        // when
        List<Integer> input = Util.rawDataToInput(rawData);
        BaseballNumberGenerator baseballNumberGenerator = new BaseBallNumberInputGenerator(input);

        // then
        assertThat(baseballNumberGenerator).isNotNull();
    }

}