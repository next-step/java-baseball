package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    @Test
    @DisplayName("게임의 정답이 같다면 두 게임은 동일한 게임이다.")
    void equalTest() {
        GameNumber answer = makeAnswer();
        BaseballGame baseballGame = new BaseballGame(answer);
        BaseballGame baseballGame2 = new BaseballGame(answer);
        assertThat(baseballGame).isEqualTo(baseballGame2);
    }

    private GameNumber makeAnswer() {
        List<GameDigit> gameDigits = new ArrayList<>();
        gameDigits.add(new GameDigit(0));
        gameDigits.add(new GameDigit(1));
        gameDigits.add(new GameDigit(2));
        return new GameNumber(gameDigits);
    }

    @Test
    @DisplayName("게임을 새로 시작한다 > 랜덤한 게임 숫자(GameNumber) 를 `정답`으로 가진 숫자 야구 게임(BaseballGame) 을 제공한다.")
    void createGameTest() {
        BaseballGame baseballGame = new BaseballGame(makeAnswer());
        BaseballGame newGame = BaseballGame.startNewGame();

        assertThat(baseballGame).isNotEqualTo(newGame);
    }

}