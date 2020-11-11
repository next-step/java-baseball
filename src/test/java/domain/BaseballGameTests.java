package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTests {
    private BaseballNumbersGenerator generator;

    @BeforeEach
    public void setup() {
        generator = new StaticBaseballNumbersGenerator(1, 2, 3);
    }

    @DisplayName("BaseballNumbersGenerator를 주입 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        BaseballGame baseballGame = BaseballGame.init(generator);

        assertThat(baseballGame).isNotNull();
        assertThat(baseballGame.getSizeOfBaseballNumbers()).isEqualTo(3);
    }
}
