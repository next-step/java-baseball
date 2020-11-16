package service;

import interfaces.Ball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BallImplementTest {

    @Test
    @DisplayName("숫자 램덤기능 테스트")
    public void randomTest(){
        //given
        Ball ball = new BallImplement();

        //when
        int beforeShuffleNumber = ball.selectThreeBalls();
        ball.shuffleBall();
        int afterShuffleNumber = ball.selectThreeBalls();

        while(beforeShuffleNumber == afterShuffleNumber){
            ball.shuffleBall();
        }
        //then
        assertThat(afterShuffleNumber).as("랜덤 기능 구현").isNotEqualTo(beforeShuffleNumber);
    }

}