package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrikeTest {

    @Test
    @DisplayName("스트라이크 허용 범위가 0~3을 벗어나면 IllegalArgumentException를 리턴한다.")
    public void validationOverStrike() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Strike.of(4);
        });
    }

    @Test
    @DisplayName("스트라이크 점수가 맞는지 비교한다.")
    public void strikeCheck() {
        assertThat(Strike.of(3).toString()).isEqualTo("3");
    }
}