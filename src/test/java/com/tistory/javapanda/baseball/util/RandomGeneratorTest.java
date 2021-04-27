package com.tistory.javapanda.baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @Test
    @DisplayName("상대방(컴퓨터) 숫자 3자리 채번 확인")
    public void randomNumbersSize() {
        assertThat(RandomGenerator.getNumbers()).hasSize(3);
    }

    @Test
    @DisplayName("1~9 범위 내의 숫자 생성 여부 테스트. 랜덤값이므로 충분한 반복횟수로 올바른 값이 반환되는 지 확인한다.")
    public void randomNumberRange() {
        for(int i=0; i<100; i++) {
            assertThat(RandomGenerator.getNumber()).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }
    }

}
