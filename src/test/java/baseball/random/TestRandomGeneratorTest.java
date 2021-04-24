package baseball.random;

import baseball.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestRandomGeneratorTest {

    @DisplayName("TestRandomGenerator getRandomNumber는 shuffle하지 않는 Numbers를 반환한다")
    @Test
    void getRandomNumberTest() {
        final Random testRandomGenerator = new TestRandomGenerator();
        final Numbers randomNumber = testRandomGenerator.getRandomNumber(3);
        assertThat(randomNumber.getNumbers()).containsExactly("1", "2", "3");
    }

}
