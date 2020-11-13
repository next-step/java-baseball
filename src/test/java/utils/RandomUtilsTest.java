package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {

    @DisplayName("1~9 사이 숫자가 생성되는지 확인")
    @Test
    void checkRange() {
        int number = RandomUtils.random();
        assertTrue(1 <= number && number <=9);
    }
}
