package domain.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputCoinTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("입력한 값이 제대로 저장되는지")
    void in_input_number() {

        // given
        String inputCli = "2";
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));
        InputCoin inputNumber = InputCoin.newInstance();
        String expected = "2";

        // when
        String input = inputNumber.getInput();

        // then
        assertEquals(expected, input);
    }

    @Test
    @DisplayName("입력 값이 1,2가 아닐때")
    void in_input_non_one_or_two() {

        // given
        String inputCli = "3";
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));
        InputCoin inputCoin = InputCoin.newInstance();

        // when
        try {
            Method validInput = inputCoin.getClass().getDeclaredMethod("validInput");
            validInput.setAccessible(true);
            validInput.invoke(inputCoin);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // then
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\r\n1 또는 2를 입력해주세요.\r\n", outContent.toString());
    }
}