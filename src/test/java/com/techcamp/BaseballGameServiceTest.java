package com.techcamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BaseballGameServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseballGameServiceTest.class);

    @Autowired
    private BaseballGameService service;

    @BeforeEach
    void before() {
        service.reset();
    }

    @RepeatedTest(10)
    void 숫자야구_초기화_테스트() {
        logger.info("ANSWER:" + service.getAnswer());
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"123", "456", "789", "adb", "12345"})
    void 숫자야구_유효성검증_테스트(String in) {
        service.input(in);
    }

    @Test
    void 숫자야구_숫자야구게임진행_테스트() {
    }

    @Test
    void 숫자야구_성공후재시작_테스트() {
    }
}