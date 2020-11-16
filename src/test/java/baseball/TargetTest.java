package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.Target.getUnique;

class TargetTest {

    @DisplayName("경계 테스트 - 1이나오는지 ")
    @Test
    void getUnique_test_bound_1() {
        List<Integer> except1 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
        int unique = getUnique(except1);
        Assertions.assertEquals(1, unique);
    }

    @DisplayName("경계 테스트 - 9나오는지 ")
    @Test
    void getUnique_test_bound_9() {
        List<Integer> except9 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int unique = getUnique(except9);
        Assertions.assertEquals(9, unique);
    }
}