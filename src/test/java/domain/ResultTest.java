package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("결과값 저장 정상여부 테스트 -1 스트라이크")
    @Test
    public void save_strike() {
        Result result = new Result();
        result.put(Score.STRIKE);

        assertThat(result.getStrikeCount()).isEqualTo(1);
    }

    @DisplayName("결과값 저장 정상여부 테스트 -3 볼")
    @Test
    public void save_ball() {
        Result result = new Result();
        result.put(Score.BALL);
        result.put(Score.BALL);
        result.put(Score.BALL);

        assertThat(result.getBallCount()).isEqualTo(3);
    }

    @DisplayName("결과값 저장 정상여부 테스트 -낫싱")
    @Test
    public void save_nothing() {
        Result result = new Result();

        assertThat(result.isNothing()).isTrue();
    }

    @DisplayName("결과값 저장 정상여부 테스트 -3스트라이크 게임종료")
    @Test
    public void save_gameEnd() {
        Result result = new Result();
        result.put(Score.STRIKE);
        result.put(Score.STRIKE);
        result.put(Score.STRIKE);

        assertThat(result.isGameEnd()).isTrue();
    }
}