package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseballUserTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "123",
            "456",
            "789",
            "158",
            "951"
    })
    void 사용자가_유효한_BaseballNumber_생성(String userInput) {
        final int EXPECTED_NUMBER = 3;
        BaseballUser baseballUser = new BaseballUser();
        BaseballNumber baseballNumber = baseballUser.inputNumber(userInput);
        assertEquals(EXPECTED_NUMBER, baseballNumber.size());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "113",
            "446",
            "779",
            "12",
            "9512"
    })
    void 사용자가_유효하지_않은_BaseballNumber_생성(String userInput) {
        BaseballUser baseballUser = new BaseballUser();
        assertThrows(IllegalArgumentException.class, () -> baseballUser.inputNumber(userInput));
    }
}