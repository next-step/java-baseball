package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PitchingTest {
    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    public void 같은_수가_같은_자리에_있으면_스트라이크() {
        Position source = new Position(1);
        Position dest = new Position(1);

        assertThat(Pitching.of(source, dest))
                .isEqualTo(Pitching.STRIKE);
    }

    @Test
    @DisplayName("같은 수가 전혀 없으면 포볼 또는 낫싱")
    public void 같은_수가_전혀_없으면_포볼_또는_낫싱() {
        Position source = new Position(1);
        Position dest = Position.NOT_FOUND;

        assertThat(Pitching.of(source, dest))
                .isEqualTo(Pitching.MISSING);
    }

    @Test
    @DisplayName("같은 수가 다른자리에 있으면 볼")
    public void 같은_수가_다른자리에_있으면_볼() {
        Position source = new Position(1);
        Position dest = new Position(2);

        assertThat(Pitching.of(source, dest))
                .isEqualTo(Pitching.BALL);
    }
}
