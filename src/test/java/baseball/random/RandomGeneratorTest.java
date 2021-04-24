package baseball.random;

import baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @DisplayName("RandomGenerator getRandomNumber는 shuffle한 Numbers를 반환한다")
    @Test
    void getRandomNumberTest() {
        final Random testRandomGenerator = new RandomGenerator();
        final Numbers randomNumber = testRandomGenerator.getRandomNumber(3);
        assertThat(randomNumber.getNumbers()).doesNotContainSequence("1", "2", "3");
    }

}
