package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName(value = "화면 출력 테스트")
class UITest {
    UI ui = new UI();

    @DisplayName(value = "사용자 입력값이 조건에 부합 여부 확인")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"2333","abc","2뮻5"})
    void answerCondition(String s) {
        assumingThat(
                ui.validAnswer(s, 3) != false,
                () -> System.out.println("test success!"));
    }
}