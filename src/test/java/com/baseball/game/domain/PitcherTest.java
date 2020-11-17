package com.baseball.game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("투수 생성 테스트")
class PitcherTest {

    @RepeatedTest(value=1_000, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("투수 - NumberBox에 존재하지 않는 수를 생성한다")
    void createDistinctNumber(){
        // given
        NumberBox numberBox = NumberBox.of(0, 1);
        NumberBox numberBox2 = NumberBox.of(1, 2);
        Pitcher pitcher = Pitcher.create();
        pitcher.setNumberBox(Arrays.asList(numberBox, numberBox2));

        //when
        int distinctNumber = pitcher.getDistinctValue();

        // then
        assertTrue(distinctNumber > 2 && distinctNumber < 10);
    }

}