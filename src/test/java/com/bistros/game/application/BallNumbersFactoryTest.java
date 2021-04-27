package com.bistros.game.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

class BallNumbersFactoryTest {

    private BallNumbersFactory ballNumbersFactory;

    @BeforeEach
    public void before() {
        ballNumbersFactory = new BallNumbersFactory(new Random());
    }


    // XXX: RepeatedTest 는 `test` 자체를 여러번 수행된다. 필요한 것은 N번 실행이기 때문에 while 으로 충분하다고 판단
    @Test
    @DisplayName("생성조건에 부합되게 정답 숫자 셋이 만들어지는지 여러번 수행")
    void multiple_generate_ballNumber_instance() {
        int repeat_count = 100;

        long generatedInstanceCount = IntStream.range(0, repeat_count)
            .mapToObj(c -> ballNumbersFactory.generate()).count();

        Assertions.assertEquals(100, generatedInstanceCount);
    }
}