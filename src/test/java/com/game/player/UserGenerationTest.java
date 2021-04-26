package com.game.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class UserGenerationTest {
    @DisplayName("사용자가 올바르게 입력했을 때 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void getTargetNumberTest(String input) {

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserGeneration generationUtil = new UserGeneration();
        List<String> numberList = generationUtil.getTargetNumber();

        assertThat(numberList)
                .hasSize(3)
                .filteredOn(m -> numberList.contains(m) == false)
                .filteredOn(m -> Integer.parseInt(m) < 10)
                .filteredOn(m -> Integer.parseInt(m) > 0);
    }

    @DisplayName("사용자가 3자리가 아닌 수를 입력했을 때 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4546"})
    void getTargetNumberTest2(String input) {

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserGeneration generationUtil = new UserGeneration();

        assertThatThrownBy(() -> {
            List<String> numberList = generationUtil.getTargetNumber();
        }).isInstanceOf(NumberFormatException.class)
                .withFailMessage("입력에 실패하였습니다");

    }

    @DisplayName("사용자가 중복숫자 입력했을 때 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"444"})
    void getTargetNumberTest3(String input) {

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserGeneration generationUtil = new UserGeneration();

        assertThatThrownBy(() -> {
            List<String> numberList = generationUtil.getTargetNumber();
        }).isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("입력에 실패하였습니다.");

    }

    @DisplayName("사용자가 문자 입력했을 때 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4dd"})
    void getTargetNumberTest4(String input) {

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserGeneration generationUtil = new UserGeneration();

        assertThatThrownBy(() -> {
            List<String> numberList = generationUtil.getTargetNumber();
        }).isInstanceOf(NumberFormatException.class)
                .withFailMessage("입력에 실패하였습니다.");

    }


}