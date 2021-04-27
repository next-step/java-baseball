package service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumingThat;

class UITest {
    UI ui = new UI();

    @ParameterizedTest
    @ValueSource(strings = {"2333","abc","2뮻5"})
    void answerCondition(String s) {
        assumingThat(
                ui.validAnswer(s, 3) != false,
                () -> System.out.println("test success!"));
    }
}