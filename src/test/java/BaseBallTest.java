import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseBallTest {

    @Test
    @DisplayName("같은 수가 전혀 없으면 포볼 또는 낫싱이다.")
    void fourBall() {
        BaseBall baseball = new BaseBall("123");
        Map<Judgements, Integer> play = baseball.play("659");

        assertThat(play).isEmpty();
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 1개 있으면 1스트라이크이다.")
    void oneStrike() {
        BaseBall baseball = new BaseBall("123");
        Map<Judgements, Integer> hint = baseball.play("189");

        assertThat(hint.get(Judgements.STRIKE)).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 2개 있으면 2스트라이크이다.")
    void twoStrike() {
        BaseBall baseball = new BaseBall("123");
        Map<Judgements, Integer> hint = baseball.play("129");

        assertThat(hint.get(Judgements.STRIKE)).isEqualTo(2);
    }
}
