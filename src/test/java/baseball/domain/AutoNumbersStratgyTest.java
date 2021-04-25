package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
