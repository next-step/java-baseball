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
}
