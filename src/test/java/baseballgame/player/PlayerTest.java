package baseballgame.player;

import baseballgame.constant.BallCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class PlayerTest {

    @Test
    @DisplayName("정상적인 플레이어 생성")
    void createPlayer_validArgument_success() {
        Integer[] integers = new Integer[]{1, 2, 3};
        Player player = Player.createPlayer(integers);
        assertThat(player.getBalls().size()).isEqualTo(BallCount.COUNT);
    }

    @Test
    @DisplayName("비정상적인 플레이어 생성 - 공들의 중복")
    void createPlayer_duplicateArgument_fail() {
        Integer[] integers = new Integer[]{1, 2, 2};
        assertThatThrownBy(() -> {
            Player player = Player.createPlayer(integers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비정상적인 플레이어 생성 - 공의 범위 초과")
    void createPlayer_outOfRangeArgument_fail() {
        Integer[] integers = new Integer[]{1, 2, 99999};
        assertThatThrownBy(() -> {
            Player player = Player.createPlayer(integers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}