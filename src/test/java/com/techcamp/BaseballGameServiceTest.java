package com.techcamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BaseballGameServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseballGameServiceTest.class);

    @Autowired
    private BaseballGameService baseballGameService;

    @BeforeEach
    void before() {
        baseballGameService.reset();
    }

    @RepeatedTest(10)
    void 숫자야구_초기화_테스트() {
        logger.info("ANSWER:" + baseballGameService.getAnswer());
    }

    @Test
    void 숫자야구_유효성검증_테스트() {
    }

    @Test
    void 숫자야구_숫자야구게임진행_테스트() {
    }

    @Test
    void 숫자야구_성공후재시작_테스트() {
    }
}