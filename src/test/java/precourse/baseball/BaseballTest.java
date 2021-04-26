package precourse.baseball;

import static org.assertj.core.api.Assertions.*;
import static precourse.constant.BaseballGameMessage.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballTest {

    @DisplayName("동일성 비교 : 두 야구공의 숫자가 같으면, 두 야구공은 같은 야구공이다.")
    @Test
    void equalBaseball() {
        Baseball baseball1 = new Baseball(1);
        Baseball baseball2 = new Baseball(1);

        assertThat(baseball1).isEqualTo(baseball2);
    }

    @DisplayName("동일성 비교 : 두 야구공의 숫자가 다르면, 두 야구공은 다른 야구공이다.")
    @Test
    void notEqualBaseball() {
        Baseball baseball1 = new Baseball(1);
        Baseball baseball2 = new Baseball(2);

        assertThat(baseball1).isNotEqualTo(baseball2);
    }

    @DisplayName("1 ~ 9 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "숫자 : {0}")
    @ValueSource(ints = {0, 10, 100})
    void invalidNumber(int invalidNumber) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Baseball(invalidNumber))
            .withMessage(INVALID_ANSWER.content());
    }

}
