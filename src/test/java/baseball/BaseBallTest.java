package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseBallTest {

    BaseBall baseBall = new BaseBall();

    @Test
    @DisplayName("컴퓨터 숫자의 출력값 중복 체크")
    public void checkDuplicateToLoopTest() {
        assertThat(baseBall.validateNumber("3s")).isFalse();
        assertThat(baseBall.validateNumber("123")).isTrue();
        assertThat(baseBall.validateNumber("222")).isFalse();
        assertThat(baseBall.validateNumber("023")).isFalse();
        assertThat(baseBall.validateNumber("1240")).isFalse();
    }

    @Test
    @DisplayName("게임 실행 결과 테스트")
    public void playTest() {
        HashMap<GameResult, Integer> expected = new HashMap<>();
        expected.put(GameResult.STRIKE, 3);
        HashMap<GameResult, Integer> actual = baseBall.run("123", "123");
        assertEquals(expected, actual);

        actual = baseBall.run("192", "123");
        expected = new HashMap<>();
        expected.put(GameResult.STRIKE, 1);
        expected.put(GameResult.BALL, 1);
        expected.put(GameResult.NOTHING, 1);
        assertEquals(expected, actual);

        actual = baseBall.run("576", "123");
        expected = new HashMap<>();
        expected.put(GameResult.NOTHING, 3);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("게임의 승리여부를 판단하는 테스트")
    public void winOrLoseTest() {
        HashMap<GameResult, Integer> expected = new HashMap<>();
        expected.put(GameResult.STRIKE, 3);
        assertThat(baseBall.confirmResult(expected)).isTrue();

        expected = new HashMap<>();
        expected.put(GameResult.STRIKE, 1);
        expected.put(GameResult.BALL, 1);
        expected.put(GameResult.NOTHING, 1);
        assertThat(baseBall.confirmResult(expected)).isFalse();

        expected = new HashMap<>();
        expected.put(GameResult.BALL, 3);
        assertThat(baseBall.confirmResult(expected)).isFalse();
    }

    @Test
    @DisplayName("게임 종료에 대한 값 테스트")
    public void isFinishTest() {
        assertThat(baseBall.checkFinishValue("1")).isFalse();
        assertThat(baseBall.checkFinishValue("2")).isFalse();
        assertThat(baseBall.checkFinishValue("32")).isTrue();
    }
}