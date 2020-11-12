package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTests {
    @DisplayName("BaseballNumbersGenerator를 주입 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        MockBaseballNumbersGenerator generator = new MockBaseballNumbersGenerator(1, 2, 3);

        BaseballGame baseballGame = BaseballGame.init(generator);

        assertThat(baseballGame).isNotNull();
        assertThat(generator.isGenerated()).isTrue();
    }
}
