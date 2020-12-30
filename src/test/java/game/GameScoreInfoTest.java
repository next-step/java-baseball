package game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GameScoreInfoTest {

    private GameScoreInfo gameScoreInfo;

    @BeforeAll
    void setGameScoreInfo() {
        gameScoreInfo = new GameScoreInfo();
    }

    @Test
    void makeScoreResultString_threeStrike_zeroBall() {
        gameScoreInfo.setStrikeCount(3);
        gameScoreInfo.setBallCount(0);

        assertThat(gameScoreInfo.makeScoreResultString())
                .isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void makeScoreResultString_zeroStrike_zeroBall() {
        gameScoreInfo.setStrikeCount(0);
        gameScoreInfo.setBallCount(0);

        assertThat(gameScoreInfo.makeScoreResultString())
                .isEqualTo("낫싱");
    }

    @Test
    void makeScoreResultString_zeroStrike_oneBall() {
        gameScoreInfo.setStrikeCount(0);
        gameScoreInfo.setBallCount(1);

        assertThat(gameScoreInfo.makeScoreResultString())
                .isEqualTo("1볼");
    }

    @Test
    void makeScoreResultString_oneStrike_zeroBall() {
        gameScoreInfo.setStrikeCount(1);
        gameScoreInfo.setBallCount(0);

        assertThat(gameScoreInfo.makeScoreResultString())
                .isEqualTo("1 스트라이크");
    }

    @Test
    void makeScoreResultString_oneStrike_oneBall() {
        gameScoreInfo.setStrikeCount(1);
        gameScoreInfo.setBallCount(2);

        assertThat(gameScoreInfo.makeScoreResultString())
                .isEqualTo("1 스트라이크 2볼");
    }

}