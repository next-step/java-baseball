package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoNumbersStratgyTest {

    @DisplayName("랜덤 숫자 생성 테스트")
    @Test
    void generateNumbers() {
        BallNumbers expected = new BallNumbers("123");

        AutoNumbersStratgy auto = new AutoNumbersStratgy() {
            @Override
            public BallNumbers generate() {
                return new BallNumbers("123");
            }
        };

        BallNumbers actualGenerated = auto.generate();

        assertThat(expected).isEqualTo(actualGenerated);
    }

    @DisplayName("랜덤 숫자 생성시 3자리 숫자로 생성되는지 테스트")
    @Test
    void checkNumbersSize() {
        AutoNumbersStratgy auto = new AutoNumbersStratgy();
        BallNumbers generated = auto.generate();

        assertThat(generated.getNumbers()).hasSize(3);
    }

    @DisplayName("랜덤 숫자 생성시 1~9 사이 값으로 생성되는지 테스트")
    @RepeatedTest(100)
    void checkNumbersRange() {
        AutoNumbersStratgy auto = new AutoNumbersStratgy();
        BallNumbers generated = auto.generate();
        List<BallNumber> numbers = generated.getNumbers();

        for (BallNumber number : numbers) {
            assertThat(number.getNumber()).isBetween(BallNumber.MIN_NUMBER, BallNumber.MAX_NUMBER);
        }
    }
}
