package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void init() {
        player = Player.of("123");
    }

    @Test
    void 생성_테스트() {
        // given
        PitchNumbers pitchNumbers = PitchNumbers.of("123");
        // when & then
        assertThat(player).isEqualTo(Player.of(pitchNumbers));
    }

    @Test
    void 게임_진행_테스트() {
        // when
        player.play("123");
        // then
        assertThat(player.isFinished()).isTrue();
    }
}
