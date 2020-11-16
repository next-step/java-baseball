package com.woowa.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameHandlerTest {

    private GameHandler gh;
    ArrayList<String> array;

    @BeforeEach
    void setup() {
        gh = new GameHandler();
        array = new ArrayList<>();
        array.add("1");
        array.add("2");
    }

    @Test
    void getRandomNumberTest() {
        Assertions.assertThat(gh.getRandomNumber().matches("\\d{1}")).isTrue();
    }

    @Test
    void getThreeNumberTest() {
        Assertions.assertThat(gh.getThreeNumber().matches("\\d{3}")).isTrue();
    }

    @Test
    @DisplayName("add number 1 test no duplicate number")
    void addNumberTest() {
        Assertions.assertThat(gh.addNumber(array,"1")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("add number 2 test no duplicate number")
    void addNumberTest2() {
        Assertions.assertThat(gh.addNumber(array,"2")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("add number 3 test no duplicate number")
    void addNumberTest3() {
        Assertions.assertThat(gh.addNumber(array,"3")).containsExactly("1", "2", "3");
    }

    @Test
    void changeListToStringTest() {
        Assertions.assertThat(gh.changeListToString(array)).isEqualTo("12");
    }

}
