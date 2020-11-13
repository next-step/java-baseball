package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.validator.GameNumberValidator.INVALID_GAME_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameNumberTest {

    @DisplayName("getInstance() 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - number={0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void getInstance(int number) {
        GameNumber gameNumber = GameNumber.getInstance(number);

        assertThat(gameNumber).isNotNull();
        assertThat(gameNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("getInstance() 오류 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - number={0}")
    @ValueSource(ints = {-1, 0, 10, 11})
    void getInstanceForInvalidNumbers(int number) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> GameNumber.getInstance(number));

        assertThat(exception.getMessage()).isEqualTo(INVALID_GAME_NUMBER_MESSAGE);
    }
}