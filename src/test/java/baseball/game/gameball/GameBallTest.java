package baseball.game.gameball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameBallTest {

    private GameBall gameBall;

    @BeforeEach
    void setup() {
        gameBall = GameBall.create();
    }

    @Test
    @DisplayName("임의의 세자리 수로 이루어진 게임볼 객체를 생성할 수 있다")
    void should_hasThreeDigitNumber_When_createRandomNumber() {

        // When
        gameBall = GameBall.create();

        // Then
        assertThat(gameBall.toString().length()).isEqualTo(GameBall.Policy.DIGIT_NUMBER);
    }

    @Test
    @DisplayName("지정된 세자리 수로 이루어진 게임볼 객체를 생성할 수 있다")
    void should_hasThreeDigitNumber_When_createInputNumber() {

        // Given
        Integer number = 123;

        // When
        gameBall = GameBall.create(number);

        // Then
        assertThat(gameBall.toString().length()).isEqualTo(GameBall.Policy.DIGIT_NUMBER);
        assertThat(gameBall.toInteger()).isEqualTo(number);
        assertThat(gameBall.toString()).isEqualTo(String.valueOf(number));
    }

    @Test
    @DisplayName("지정된 세자리 문자열 수로 이루어진 게임볼 객체를 생성할 수 있다")
    void should_hasThreeDigitNumber_When_createInputString() {

        // Given
        String number = "123";

        // When
        gameBall = GameBall.create(number);

        // Then
        assertThat(gameBall.toString().length()).isEqualTo(GameBall.Policy.DIGIT_NUMBER);
        assertThat(gameBall.toString()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {111, 121, 112, 211})
    @DisplayName("지정된 세자리 문자열 수로 이루어진 게임볼 객체를 생성할 수 있다")
    void should_FailIllegalArgumentException_When_overlapNumber(Integer num) {

        assertThatIllegalArgumentException().isThrownBy(() -> GameBall.create(num));
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "121", "112", "211"})
    @DisplayName("지정된 세자리 문자열 수로 이루어진 게임볼 객체를 생성할 수 있다")
    void should_FailIllegalArgumentException_When_overlapNumber(String num) {

        assertThatIllegalArgumentException().isThrownBy(() -> GameBall.create(num));
    }

}