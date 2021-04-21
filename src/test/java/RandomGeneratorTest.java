import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    private RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = new RandomGenerator();
    }

    @DisplayName("난수 생성 범위 검증")
    @RepeatedTest(100)
    void test01() {

        int actual = randomGenerator.nextInt();
        int expectedMinNumber = 1;
        int expectedMaxNumber = 9;

        assertThat(actual).isGreaterThanOrEqualTo(expectedMinNumber)
                          .isLessThanOrEqualTo(expectedMaxNumber);

    }
}