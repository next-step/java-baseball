package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrialTest {

    @DisplayName("생성자 테스트")
    @Test
    void of_test() {
        Trial sut = Trial.of("123");
        assertAll(() -> assertEquals(sut.value.get(0), 1),
                  () -> assertEquals(sut.value.get(1), 2),
                  () -> assertEquals(sut.value.get(2), 3));
    }

    @DisplayName("중복 테스트")
    @Test
    void of_test_checkDup() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> Trial.of("111"));
    }

    @DisplayName("길이 테스트")
    @Test
    void of_test_checkSize() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> Trial.of("1234"));
    }
}