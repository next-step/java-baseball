package me.nimkoes.baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberRepositoryTest {

    @Test
    @DisplayName("값이 저장되고 불러와지는지 확인")
    void getTargetNumber() {
        // given
        String testValue = "21";
        RandomNumberRepository randomNumberRepository = RandomNumberRepository.getInstance();

        // when
        randomNumberRepository.setTargetNumber(testValue);

        // then
        assertThat(randomNumberRepository.getTargetNumber()).isEqualTo(testValue);
    }

    @Test
    @DisplayName("값이 싱글톤으로 생성 되는지 확인")
    void checkSingletonObject() {
        // given
        RandomNumberRepository randomNumberRepository_1 = RandomNumberRepository.getInstance();
        RandomNumberRepository randomNumberRepository_2 = RandomNumberRepository.getInstance();

        // then
        assertThat(randomNumberRepository_1).isSameAs(randomNumberRepository_2);
    }
}
