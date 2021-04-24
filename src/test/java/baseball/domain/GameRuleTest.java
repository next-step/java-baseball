package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRuleTest {
    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    public void 같은_수가_같은_자리에_있으면_스트라이크() {
        Position source = new Position(1);
        Position dest = new Position(1);


        assertThat(GameRule.of(source, dest))
                .isEqualTo(GameRule.STRIKE);
    }

    @Test
    @DisplayName("같은 수가 전혀 없으면 포볼 또는 낫싱")
    public void 같은_수가_전혀_없으면_포볼_또는_낫싱() {
        Position source = new Position(1);
        Position dest = Position.NOT_FOUND;


        assertThat(GameRule.of(source, dest))
                .isEqualTo(GameRule.MISSING);
    }
}
