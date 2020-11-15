import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    @DisplayName("입력된 값이 0이 포함되지 않은 3자리 숫자로만 이루어져 있는지 검증")
    public void validInputString() {
        int result = player.checkUserInput("abc");
        assertEquals(result, BaseballGame.INPUT_ERROR);

        result = player.checkUserInput("103");
        assertEquals(result, BaseballGame.INPUT_ERROR);

        result = player.checkUserInput("119");
        assertEquals(result, 119);

        result = player.checkUserInput("123");
        assertEquals(result, 123);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("숫자의 각 자리수를 배열로 변환")
    public void convertIntToArray(int input) {
        ArrayList<Integer> result = player.convertNumberToList(123);
        assertThat(result.contains(input)).isTrue();
    }

}