package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    @DisplayName("3자리의 랜덤함 수 생성 테스트")
    void generate() {
        String number = NumberGenerator.generate();

        assertThat(number.length()).isEqualTo(3);
    }

}