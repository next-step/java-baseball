package baseball.game;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.exception.CustomException;
import baseball.common.PrintMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateBallTest {

    private CreateBall createBall;

    @BeforeEach
    void setUp() {
        createBall = new CreateBall();
    }

    @DisplayName("숫자 랜덤 크기 체크")
    @ParameterizedTest
    @ValueSource(ints = { 3 })
    void random_base_ball_size(final int maxSize) {
        assertEquals(createBall.getBalls().size(), maxSize);
    }

    @DisplayName("현재 등록 된 랜덤 숫자 최소값 0인 경우")
    @ParameterizedTest(name = "{index} => oneNumber={0}, twoNumber={1}, threeNumber={2}")
    @CsvSource({
        "0, 5, 9",
        "5, 8, 0"
    })
    void random_base_ball_min_number(final int oneNumber,
                                     final int twoNumber,
                                     final int threeNumber) {
        CustomException.InvalidateRandomNumberMinMaxError exception = assertThrows(
            CustomException.InvalidateRandomNumberMinMaxError.class,
            () -> createBall.validateRandomBallMax(new LinkedHashSet<>(Arrays.asList(oneNumber, twoNumber, threeNumber)))
        );

        assertTrue(exception.getMessage().contains(PrintMessage.RANDOM_NUMBER_MIN_MAX_ERROR));
    }

    @DisplayName("현재 등록 된 랜덤 숫자 최대값이 10인 경우")
    @ParameterizedTest(name = "{index} => oneNumber={0}, twoNumber={1}, threeNumber={2}")
    @CsvSource({
        "10, 5, 9",
        "5, 8, 10"
    })
    void random_base_ball_max_number(final int oneNumber,
                                     final int twoNumber,
                                     final int threeNumber) {
        CustomException.InvalidateRandomNumberMinMaxError exception = assertThrows(
            CustomException.InvalidateRandomNumberMinMaxError.class,
            () -> createBall.validateRandomBallMax(new LinkedHashSet<>(Arrays.asList(oneNumber, twoNumber, threeNumber)))
        );

        assertTrue(exception.getMessage().contains(PrintMessage.RANDOM_NUMBER_MIN_MAX_ERROR));
    }

    @DisplayName("현재 등록 된 랜덤 숫자의 길이가 3이 아닌 경우 (LinkedHashSet)의 중복 여부 체크")
    @ParameterizedTest(name = "{index} => oneNumber={0}, twoNumber={1}, threeNumber={2}")
    @CsvSource({
        "5, 5, 9",
        "5, 8, 8"
    })
    void validate_random_base_ball_size(final int oneNumber,
                                        final int twoNumber,
                                        final int threeNumber) {
        CustomException.InvalidateNumberSizeError exception = assertThrows(
            CustomException.InvalidateNumberSizeError.class,
            () -> createBall.validateRandomBallSize(new LinkedHashSet<>(Arrays.asList(oneNumber, twoNumber, threeNumber)))
        );

        assertTrue(exception.getMessage().contains(PrintMessage.RANDOM_NUMBER_SIZE_ERROR));
    }

}
