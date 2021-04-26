package baseball.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("플레이어 도메인 테스트")
class PlayerTest {

    @DisplayName("플레이어 상태 확인")
    @Test
    void 플레이어_상태_확인() {
        // when
        Player player = new Player(PlayStatus.PLAY);
        // then
        assertThat(player.isPlaying()).isEqualTo(true);
    }
}