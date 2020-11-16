package com.woowa.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class GameHandlerTest {

    private GameHandler gh;

    @BeforeEach
    void setup() {
        gh = new GameHandler();
    }

    @Test
    void getRandomNumberTest() {
        Assertions.assertThat(gh.getRandomNumber().matches("\\d{1}")).isTrue();
    }

    @Test
    void getThreeNumberTest() {
        Assertions.assertThat(gh.getThreeNumber().matches("\\d{3}")).isTrue();
    }

}
