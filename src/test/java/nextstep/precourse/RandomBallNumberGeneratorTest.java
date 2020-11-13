package nextstep.precourse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBallNumberGeneratorTest {

    @Test
    @DisplayName("서로 다른 3개의 0-9 사이의 숫자가 생성되어야 한다.")
    void generate() {
        Set<Integer> randomIntSet = new HashSet<>();

        randomIntSet = RandomBallNumberGenerator.generateRandomInt();

        assertThat(randomIntSet.size()).isEqualTo(3);
    }
}
