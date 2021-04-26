package com.game.baseball;

import com.game.player.ComGeneration;
import com.game.player.GenerationUtil;
import com.game.player.UserGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {
    @DisplayName("컴퓨터 숫자, 사용자숫자 일치하도록 진행하여 테스트")
    @Test
    void playGame() {

        GenerationUtil comGenerationUtil = new ComGeneration();
        GenerationUtil userGenerationUtil = new UserGeneration();
        BaseballGame baseballGame = new BaseballGame(comGenerationUtil, userGenerationUtil);

        List<String> inputList = comGenerationUtil.getTargetNumber();
        String input = "";
        for(String number : inputList){
            input += number;
        }

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        baseballGame.playGame();
    }

    @DisplayName("컴퓨터 숫자, 사용자숫자 불일치 하도록 진행하여 테스트")
    @Test
    void playGame2() {

        GenerationUtil comGenerationUtil = new ComGeneration();
        GenerationUtil userGenerationUtil = new UserGeneration();
        BaseballGame baseballGame = new BaseballGame(comGenerationUtil, userGenerationUtil);

        List<String> inputList = comGenerationUtil.getTargetNumber();
        String input = "456333";
        for(String number : inputList){
            input += number;
        }

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            baseballGame.playGame();
        }).isInstanceOf(NumberFormatException.class)
                .withFailMessage("입력에 실패하였습니다");

    }


}