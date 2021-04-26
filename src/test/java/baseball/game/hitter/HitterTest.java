package baseball.game.hitter;

import baseball.game.gameball.GameBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HitterTest {

    @Test
    @DisplayName("타자 생성시 전달받은 임의의 번호를 swing을 반환할 수 있다")
    void should_hasRandomNumber_When_create() {

        // Given
        GameBall gameBall = GameBall.create();
        Hitter hitter = new Hitter(gameBall);

        // When
        String hitterNumber = hitter.swing();

        // Then
        assertThat(hitterNumber).isEqualTo(gameBall.toString());
    }

}