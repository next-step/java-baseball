package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBaseballNumbersGeneratorTests {
    private BaseballNumbersGenerator baseballNumbersGenerator;

    @BeforeEach
    void setup() {
        baseballNumbersGenerator = new RandomBaseballNumbersGenerator();
    }

    @DisplayName("랜덤으로 중복되지 않는 세 개의 야구게임숫자로 이루어진 컬렉션을 생성할 수 있다.")
    @Test
    void generateBaseballNumbers() {
        int expectedSize = 3;

        BaseballNumbers baseballNumbers = baseballNumbersGenerator.generate();

        assertThat(baseballNumbers.size()).isEqualTo(expectedSize);
    }
}
