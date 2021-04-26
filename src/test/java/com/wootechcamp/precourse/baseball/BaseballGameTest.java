package com.wootechcamp.precourse.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {


    BaseballGame  baseballGame = new BaseballGame();

    @Test
    @DisplayName("getSameNumber test, 1 ")
    public void existsSameNumber1(){
        // given
        int answer = 123;
        int givenNumber = 541;


        // when
        baseballGame.setIntegerToList(answer,givenNumber);
        List sameNumber = baseballGame.getSameNumbers();

        System.out.println(sameNumber.toString());
        // then
        assertThat(1).isEqualTo(sameNumber.size());

    }

    @Test
    @DisplayName("getSameNumber test, 2 ")
    public void existsSameNumber2(){
        // given
        int answer = 123;
        int givenNumber = 341;


        // when
        baseballGame.setIntegerToList(answer,givenNumber);
        List sameNumber = baseballGame.getSameNumbers();

        System.out.println(sameNumber.toString());
        // then
        assertThat(2).isEqualTo(sameNumber.size());

    }

    @Test
    @DisplayName("getSameNumber test, 3 ")
    public void existsSameNumber3(){
        // given
        int answer = 123;
        int givenNumber = 312;


        // when
        baseballGame.setIntegerToList(answer,givenNumber);
        List sameNumber = baseballGame.getSameNumbers();

        System.out.println(sameNumber.toString());
        // then
        assertThat(3).isEqualTo(sameNumber.size());

    }

    @Test
    @DisplayName("getSameNumber test, 3 ")
    public void existsSameNumber4(){
        // given
        int answer = 123;
        int givenNumber = 123;


        // when
        baseballGame.setIntegerToList(answer,givenNumber);
        List sameNumber = baseballGame.getSameNumbers();

        System.out.println(sameNumber.toString());
        // then
        assertThat(3).isEqualTo(sameNumber.size());

    }
}
