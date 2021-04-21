package domain;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseBallTest {
    private BaseBall baseBall;

    @BeforeEach
    void initilaze() {
        baseBall = null;
    }

    @DisplayName("숫자 범위가 [1, 9] 에서 벗어난 경우를 잘 감지하는지 확인한다.")
    @Test
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 11, 12, 13})
    void confirmInvalidRange(int number) {
        assertFalse(baseBall.isValidate(number));
    }



    @DisplayName("객체가 제대로 생성이 되는지 확인한다.")
    @Test
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void isObjectCreated(int number) {
        baseBall = BaseBall.fromNumber(number);
        assertTrue(baseBall.getClass() == BaseBall.class);
    }


}