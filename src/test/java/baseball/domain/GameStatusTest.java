package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameStatusTest {

    @DisplayName("continue 비교 - 성공")
    @Test
    public void equalsCode_continue_success() throws Exception {
        //given
        GameStatus status = GameStatus.CONTINUE;

        //then
        Assertions.assertTrue(status.equalsCode(1));
    }

    @DisplayName("continue 비교 - 실패")
    @ParameterizedTest
    @ValueSource(ints = {-100, -10, -1, 0, 2, 3, 4, 10, 100})
    public void equalsCode_continue_fail(int input) throws Exception {
        //given
        GameStatus status = GameStatus.CONTINUE;

        //then
        Assertions.assertFalse(status.equalsCode(input));
    }

    @DisplayName("end 비교 - 성공")
    @Test
    public void equalsCode_end_success() throws Exception {
        //given
        GameStatus status = GameStatus.END;

        //then
        Assertions.assertTrue(status.equalsCode(2));
    }

    @DisplayName("end 비교 - 실패")
    @ParameterizedTest
    @ValueSource(ints = {-100, -10, -1, 0, 1, 3, 4, 10, 100})
    public void equalsCode_end_fail(int input) throws Exception {
        //given
        GameStatus status = GameStatus.END;

        //then
        Assertions.assertFalse(status.equalsCode(input));
    }

}
