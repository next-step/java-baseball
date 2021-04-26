package baseball.game.gameball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameNumberTest {

    @Test
    @DisplayName("정수 타입의 값으로 볼 번호를 생성할 수 있다")
    void should_creteBallNumber_IntegerNumber() {

        // Given
        Integer num = 1;

        // When
        GameNumber newBallNumber = GameNumber.create(1);

        // Then
        Assertions.assertThat(newBallNumber.getNum()).isEqualTo(num);
    }

    @ParameterizedTest
    @ValueSource(ints = {GameNumber.Policy.MIN_RANGE - 1, GameNumber.Policy.MAX_RANGE + 1, -10})
    @DisplayName("허용되지 않는 정수값을 사용하여 볼 번호 생성시 잘못된 인자 예외를 발생시킨다")
    void should_failIllegalArgument_IncorrectIntegerNumber(Integer num) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> GameNumber.create(num));

    }

}