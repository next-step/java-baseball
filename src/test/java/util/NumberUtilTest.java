package util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberUtilTest {

    @Test
    @DisplayName("숫자 검증")
    void isValid() {
        List<Integer> number = NumberUtil.generate();
        assertTrue(number.get(0) != number.get(1) && number.get(0) != number.get(2) && number.get(1) != number.get(2));
    }

}