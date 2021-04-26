package com.wootechcamp.precourse.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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


    @Test
    @DisplayName("getStrikeNum test, 3 strike ")
    public void getStrikeNum1(){
        // given
        int answer = 123;
        int givenNumber = 123;

        // when
        baseballGame.setIntegerToList(answer,givenNumber);
        List sameNumber = baseballGame.getSameNumbers();
        int strikeNum = baseballGame.getStrikeNum(sameNumber);

        // then
        assertThat(3).isEqualTo(strikeNum);

    }

    @Test
    @DisplayName("getStrikeNum test, 2 strike ")
    public void getStrikeNum2(){
        // given
        int answer = 123;
        int givenNumber = 423;

        // when
        baseballGame.setIntegerToList(answer,givenNumber);
        List sameNumber = baseballGame.getSameNumbers();
        int strikeNum = baseballGame.getStrikeNum(sameNumber);

        // then
        assertThat(2).isEqualTo(strikeNum);

    }

    @Test
    @DisplayName("getStrikeNum test, 1 strike ")
    public void getStrikeNum3(){
        // given
        int answer = 123;
        int givenNumber = 425;

        // when
        baseballGame.setIntegerToList(answer,givenNumber);
        List sameNumber = baseballGame.getSameNumbers();
        int strikeNum = baseballGame.getStrikeNum(sameNumber);

        // then
        assertThat(1).isEqualTo(strikeNum);

    }

    @Test
    @DisplayName("getStrikeNum test, 0 strike ")
    public void getStrikeNum4(){
        // given
        int answer = 123;
        int givenNumber = 456;

        // when
        baseballGame.setIntegerToList(answer,givenNumber);
        List sameNumber = baseballGame.getSameNumbers();
        int strikeNum = baseballGame.getStrikeNum(sameNumber);

        // then
        assertThat(0).isEqualTo(strikeNum);

    }
}
