package baseball.models;

import baseball.configures.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.ThrowingSupplier;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumValidCheckerTest {

    AppConfig appConfig = new AppConfig();
    NumValidChecker numValidChecker = appConfig.numValidChecker();

    @Test
    @DisplayName("숫자가 오지 않을때 IllegalArgumentException 나는 테스트")
    void onlyNumberCheck() {

        String input = "abc";

        assertThrows(IllegalArgumentException.class,
                () -> numValidChecker.isNumber(input),
                "올바른 숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("세자리 숫자가 오지 않을때 IllegalArgumentException 나는 테스트")
    void onlyThreeNumberInputCheck() {

        String input = "1234";

        assertThrows(IllegalArgumentException.class,
                () -> numValidChecker.isThreeSize(input),
                "세자리 숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("올바른 숫자가 와서 성공 하는 테스트")
    void InputNumberSuccess() {
        String input = "123";

        numValidChecker.isNumber(input);
        numValidChecker.isThreeSize(input);

        Assertions.assertDoesNotThrow((ThrowingSupplier<IllegalArgumentException>) IllegalArgumentException::new);
    }

}