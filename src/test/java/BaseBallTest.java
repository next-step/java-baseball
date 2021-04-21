import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseBallTest {

    @Test
    @DisplayName("같은 수가 전혀 없으면 포볼 또는 낫싱이다.")
    void fourBall() {
        BaseBall baseball = new BaseBall("123");
        Map<Character, Integer> play = baseball.play("659");

        assertThat(play).isEmpty();
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 1개 있으면 1스트라이크이다.")
    void oneStrike() {
        BaseBall baseball = new BaseBall("123");
        Map<Character, Integer> hint = baseball.play("189");

        assertThat(hint.get('S')).isEqualTo(1);
    }
}
