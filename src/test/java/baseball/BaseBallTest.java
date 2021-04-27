package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseBallTest {

    BaseBall baseBall = new BaseBall();

    @Test
    @DisplayName("컴퓨터 숫자의 출력값 중복 체크")
    public void checkDuplicateValueTest() {
        assertThat(baseBall.validateNumber("123")).isTrue();
        assertThat(baseBall.validateNumber("222")).isFalse();
        assertThat(baseBall.validateNumber("090")).isFalse();
    }

    @Test
    @DisplayName("게임 실행 결과 테스트")
    public void playTest() {
        HashMap<GameResult, Integer> expected = new HashMap<>();
        expected.put(GameResult.STRIKE, 3);
        HashMap<GameResult, Integer> actual = baseBall.play("123", "123");
        assertEquals(expected, actual);

        actual = baseBall.play("192", "123");
        expected = new HashMap<>();
        expected.put(GameResult.STRIKE, 1);
        expected.put(GameResult.BALL, 1);
        expected.put(GameResult.NOTHING, 1);
        assertEquals(expected, actual);

        actual = baseBall.play("576", "123");
        expected = new HashMap<>();
        expected.put(GameResult.NOTHING, 3);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("게임의 승리여부를 판단하는 테스트")
    public void winOrLoseTest() {
        HashMap<GameResult, Integer> expected = new HashMap<>();
        expected.put(GameResult.STRIKE, 3);
        assertThat(baseBall.judgeGameResult(expected)).isTrue();

        expected = new HashMap<>();
        expected.put(GameResult.STRIKE, 1);
        expected.put(GameResult.BALL, 1);
        expected.put(GameResult.NOTHING, 1);
        assertThat(baseBall.judgeGameResult(expected)).isFalse();
    }

    @Test
    @DisplayName("게임 종료에 대한 값 테스트")
    public void isFinishTest() {
        assertThat(baseBall.isFinish("1")).isTrue();
        assertThat(baseBall.isFinish("2")).isFalse();

        assertThrows(IllegalArgumentException.class, () -> assertThat(baseBall.isFinish("ddf")).isFalse());
        assertThrows(IllegalArgumentException.class, () -> assertThat(baseBall.isFinish("3")).isFalse());
    }
}