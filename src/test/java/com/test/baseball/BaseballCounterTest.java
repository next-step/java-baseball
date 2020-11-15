package com.test.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballCounterTest {
    private BaseballCounter counter;

    @BeforeEach
    public void init(){
        List<Integer> list = Arrays.asList(3, 5, 7);
        counter = new BaseballCounter(list);
    }

    @ParameterizedTest
    @CsvSource({"162,0,0,true,false","123,0,1,false,false","312,1,0,false,false","752,1,1,false,false","356,2,0,false,false","347,2,0,false,false","357,3,0,false,true"})
    public void testCheckAndSetCount(String source, int strikeCount, int ballCount, boolean isNothing, boolean isFinished){
        BaseballUser user = new BaseballUser(new ByteArrayInputStream(source.getBytes()));
        List<Integer> numbers = user.getInputNumbers();
        int size = numbers.size();

        for ( int ix = 0 ; ix < size ; ix ++ ) {
            counter.chekAndSetCount(ix,numbers.get(ix));
        }

        assertThat(counter.getStrikeCount()).isEqualTo(strikeCount);
        assertThat(counter.getBallCount()).isEqualTo(ballCount);
        assertThat(counter.isNothing()).isEqualTo(isNothing);
        assertThat(counter.isFinished()).isEqualTo(isFinished);
    }

}
