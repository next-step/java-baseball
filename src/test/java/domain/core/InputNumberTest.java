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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputNumberTest {
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
    @DisplayName("입력한 숫자가 제대로 저장되는지")
    void in_input_number() {

        // given
        String inputCli = "123";
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));
        InputNumber inputNumber = InputNumber.newInstance();
        List<Integer> expectedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3));

        // when
        List<Integer> input = inputNumber.getInput();

        // then
        assertThat(expectedNumbers)
                .containsExactly(input.get(0), input.get(1), input.get(2));
    }

    @Test
    @DisplayName("입력 값이 숫자가 아닐때")
    void in_input_non_number() {

        // given
        String inputCli = "e2e";
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));
        InputNumber inputNumber = InputNumber.newInstance();

        // when
        try {
            Method validInput = inputNumber.getClass().getDeclaredMethod("validInput");
            validInput.setAccessible(true);
            validInput.invoke(inputNumber);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // then
        assertEquals("숫자를 입력해주세요 : 숫자만 입력이 가능합니다.\r\n", outContent.toString());
    }

    @Test
    @DisplayName("입력 값이 숫자가 3자리 수가 아닐 때")
    void in_input_out_of_number() {

        // given
        String inputCli = "0234";
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));
        InputNumber inputNumber = InputNumber.newInstance();

        // when
        try {
            Method validInput = inputNumber.getClass().getDeclaredMethod("validInput");
            validInput.setAccessible(true);
            validInput.invoke(inputNumber);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // then
        assertEquals("숫자를 입력해주세요 : 세자리 숫자만 입력이 가능합니다.\r\n", outContent.toString());
    }
}