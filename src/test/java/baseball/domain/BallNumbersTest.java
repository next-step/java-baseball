package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallNumbersTest {
    @DisplayName("1~9 사이의 서로 다른 수로 이루어진 임의의 세자리 문자열로 BallNumbers를 생성한다")
    @Test
    void create() {
        assertThat(BallNumbers.from("123").getNumbers())
                .isEqualTo(Arrays.asList(1, 2, 3));
    }
}