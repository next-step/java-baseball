package com.baseball.game.service;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("숫자 생성 테스트")
class NumberBoxTest {

    private NumberBox numberBox;

    @RepeatedTest(value=1_000, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("투수 - NumberBox에 존재하지 않는 수를 생성한다")
    void createDistinctNumber(){
        // given
        List<Integer> list = Lists.newArrayList(1,2);
        numberBox = new NumberBox();
        numberBox.setNumberBox(list);

        //when
        int distinctNumber = numberBox.getDistinctValue();

        // then
        assertTrue(distinctNumber > 2 && distinctNumber < 10);
    }
}