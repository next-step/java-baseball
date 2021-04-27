package kr.aterilio.nextstep.techcamp.precourse.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    @DisplayName("게임 생성 테스트")
    @Test
    public void test_createGame() {
        Baseball game = new Baseball();
        System.out.println(game);
        assertThat(game.isCreated()).isTrue();
    }

    private final Integer[] TEST_CASE = {1,2,3};

    @DisplayName("게임 생성 (지정 케이스) 및 완전 일치 여부 테스트")
    @Test
    public void test_createGame2() {
        Baseball game = new Baseball(TEST_CASE);
        assertThat(game.isEqualTo(TEST_CASE)).isTrue();
    }
}
