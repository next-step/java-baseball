package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest()
    @CsvSource(value = {"123:true", "126:false", "456:false"}, delimiter = ':')
    void 게임_진행_테스트(String input, boolean expected) {
        // when
        player.play(input);
        // then
        assertThat(player.isFinished()).isEqualTo(expected);
    }
}
