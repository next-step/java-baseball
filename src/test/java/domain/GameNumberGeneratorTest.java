package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberGeneratorTest {

    @Test
    @DisplayName("임의의 3자리 수가 생성된다.")
    void generateRandomNumberTest() {

        // given
        NumberGenerator gameNumberGenerator = new GameNumberGenerator();

        // when
        Numbers numbers = gameNumberGenerator.generate();

        // then
        assertThat(numbers).isNotNull();
    }
}