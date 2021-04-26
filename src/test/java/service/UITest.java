package service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class UITest {
    UI ui = new UI();

    @ParameterizedTest
    @ValueSource(strings = {"123","2333","a2c"})
    void answerCondition(String s) {
        assumingThat(s == "123", () ->
                assertTrue(ui.answerCondition(s, 3)));
        assumingThat(s == "2333", () ->
                assertFalse(ui.answerCondition(s, 3)));
        assumingThat(s == "a2c", () ->
                assertFalse(ui.answerCondition(s, 3)));
    }
}