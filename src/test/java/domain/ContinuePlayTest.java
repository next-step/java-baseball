package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ContinuePlayTest {

    @DisplayName("새로운게임시작 객체 생성테스트")
    @Test
    void continuePlayCreateTest() {
        ContinuePlay continuePlay = ContinuePlay.create(1);

        assertTrue(continuePlay.isContinuePlay());
    }

    @DisplayName("게임종료 객체 생성테스트")
    @Test
    void endGameCreateTest() {
        ContinuePlay continuePlay = ContinuePlay.create(2);

        assertFalse(continuePlay.isContinuePlay());
    }

    @DisplayName("1 또는 2 이외의 값 생성시 예외테스트")
    @Test
    void anotherAnswerTest() {
        assertThatThrownBy(() -> ContinuePlay.create(3)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
