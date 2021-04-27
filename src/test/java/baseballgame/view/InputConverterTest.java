package baseballgame.view;

import baseballgame.game.GameNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputConverterTest {

    @ParameterizedTest(name = "사용자는 1에서 9까지 서로 다른 임의의 수 3개를 입력할 수 있다.")
    @ValueSource(strings = {"123", "456", "789"})
    public void playerGameNumberSuccessTest(String input) {
        // when
        final GameNumber gameNumber = InputConverter.convertToGameNumber(input);
        // then
        assertThat(gameNumber).isNotNull();
    }

    @ParameterizedTest(name = "유효하지 않은 입력이 들어오면 예외가 발생한다.")
    @ValueSource(strings = {"1234", "111", "12", "test", "", " "})
    public void playerGameNumberFailTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputConverter.convertToGameNumber(input));
    }

}