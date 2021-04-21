import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseBallTest {

    @Test
    @DisplayName("같은 수가 전혀 없으면 포볼 또는 낫싱이다.")
    void fourBall() {
        BaseBall baseball = new BaseBall("123");
        String hint = baseball.play("659");

        assertThat(hint).isEqualTo("4B");
    }
}
