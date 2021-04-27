package util;

import common.Const;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤 숫자 범위와 중복체크")
    @Test
    @RepeatedTest(100)
    void makeRandomNumberSize() {
        List<Integer> randomNumbers = RandomNumberGenerator.makeBaseballNumber();

        for (int i = 0; i < randomNumbers.size(); i++) {
            assertThat(randomNumbers.get(i)).isLessThanOrEqualTo(Const.RANDOM_MAX_NUMBER+1);
            assertThat(randomNumbers).containsOnlyOnce(randomNumbers.get(i));
        }
    }
}