package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BaseballGameServiceTest {

    @Autowired
    private BaseballGameService baseballGameService;

    @Test
    void 숫자야구_초기화테스트() {
        baseballGameService.init();
        //assertThat()

    }
}