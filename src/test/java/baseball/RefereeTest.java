package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    @Test
    @DisplayName("기본테스트")
    void defaultTest() {
        Referee referee = new Referee();
        assertThat(referee.enemyNumbers.size()).isEqualTo(3);
    }
}
