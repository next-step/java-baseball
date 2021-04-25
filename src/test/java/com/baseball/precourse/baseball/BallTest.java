package com.baseball.precourse.baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


public class BallTest {

    @DisplayName("Ball 생성 요청")
    @Test
    void generateBallSuccessfullyTest(){
        // given
        final String input = "124";

        // when
        final Ball ball = new Ball(input);

        // then
        assertThat(ball).isNotNull();
    }

    @DisplayName("Ball 생성 요청 - 잘못된 길이의 입력")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1245"})
    void generateBallWithInvalidLengthInputTest(String shortInput){
        // then
        assertThatThrownBy(()->{
            // when
            new Ball(shortInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
