package com.game.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComGenerationTest {
    @Test
    @DisplayName("컴퓨터 무작위 숫자 추출")
    void getTargetNumberTest() {
        GenerationUtil generationUtil = new ComGeneration();
        List<String> list =  generationUtil.getTargetNumber();

        // 숫자무작위 테스트
        // 1~9 사이 숫자 테스트
        // 중복숫자 제거 테스트
        assertThat(list)
                .hasSize(3)
                .filteredOn(m -> list.contains(m) == false)
                .filteredOn(m -> Integer.parseInt(m) < 10)
                .filteredOn(m -> Integer.parseInt(m) > 0);
    }
}