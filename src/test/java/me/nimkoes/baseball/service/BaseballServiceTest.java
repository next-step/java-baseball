package me.nimkoes.baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import me.nimkoes.baseball.model.RandomNumberRepository;

class BaseballServiceTest {

    BaseballService baseballService;
    RandomNumberRepository randomNumberRepository;

    @BeforeEach
    void setUp() {
        randomNumberRepository = RandomNumberRepository.getInstance();
        baseballService = new BaseballService(randomNumberRepository);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123:3", "123:145:1", "123:023:2", "123:321:1"}, delimiter = ':')
    @DisplayName("스트라이크 카운트 테스트")
    void getStrikeCount(String targetNumber, String inputNumber, int expected) {
        // when
        randomNumberRepository.setTargetNumber(targetNumber);

        // then
        assertThat(baseballService.getStrikeCount(inputNumber)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:123:0", "123:145:0", "123:023:0", "123:321:2", "123:415:1", "123:231:3"}, delimiter = ':')
    @DisplayName("볼 카운트 테스트")
    void getBallCount(String targetNumber, String inputNumber, int expected) {
        // when
        randomNumberRepository.setTargetNumber(targetNumber);

        // then
        assertThat(baseballService.getBallCount(inputNumber)).isEqualTo(expected);
    }

}
