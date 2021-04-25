package baseballgame.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameNumberTest {

    @DisplayName("GameNumber를 랜덤으로 생성 할 수 있다.")
    @Test
    public void generateGameNumberRandomlyTest() {
        // when
        final GameNumber gameNumber = GameNumber.generateRandomly();
        // then
        assertThat(gameNumber).extracting("numberList").isNotNull();
    }

}