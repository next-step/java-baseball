package baseball.domain;

import baseball.exceptions.DuplicateBallNumberException;
import baseball.exceptions.InvalidBallNumbersSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static baseball.domain.PitchingResultStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("야구 숫자 일급 콜렉션 테스트")
public class BallNumbersTest {


    @DisplayName("야구 숫자 일급 콜렉션 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideBallNumbers")
    void createBallNumbersTest(List<BallNumber> ballNumbers) {
        //when
        BallNumbers createdBallNumbers = new BallNumbers(ballNumbers);

        //then
        assertThat(createdBallNumbers.containsAll(ballNumbers)).isTrue();

    }

    private static Stream<Arguments> provideBallNumbers() {
        return Stream.of(
                Arguments.of(getBallNumbers(1,2,3)),
                Arguments.of(getBallNumbers(4,5,6)),
                Arguments.of(getBallNumbers(8,7,6))
        );
    }

    @DisplayName("야구 숫자 일급 콜렉션 생성 실패 테스트 - 야구숫자가 3개 미만이거나 초과일 경우")
    @ParameterizedTest
    @MethodSource("provideInvalidSizeBallNumbers")
    void createBallNumberInvalidBallNumbersSizeExceptionTest(List<BallNumber> ballNumbers) {
        //when, then
        assertThatThrownBy(() -> {
            BallNumbers createdBallNumbers = new BallNumbers(ballNumbers);
        }).isInstanceOf(InvalidBallNumbersSizeException.class)
                .hasMessage(InvalidBallNumbersSizeException.DEFAULT_MESSAGE);
    }

    private static Stream<Arguments> provideInvalidSizeBallNumbers() {
        return Stream.of(
                Arguments.of(getBallNumbers(1,2,3,4)),
                Arguments.of(getBallNumbers(4,5))
        );
    }

    @DisplayName("야구 숫자 일급 콜렉션 생성 실패 테스트 - 야구숫자가 중복일 경우")
    @ParameterizedTest
    @MethodSource("provideDuplicateBallNumbers")
    void createBallNumberDuplicateBallNumberExceptionTest(List<BallNumber> ballNumbers) {
        //when, then
        assertThatThrownBy(() -> {
            BallNumbers createdBallNumbers = new BallNumbers(ballNumbers);
        }).isInstanceOf(DuplicateBallNumberException.class)
                .hasMessage(DuplicateBallNumberException.DEFAULT_MESSAGE);
    }

    private static Stream<Arguments> provideDuplicateBallNumbers() {
        return Stream.of(
                Arguments.of(getBallNumbers(1,1,3)),
                Arguments.of(getBallNumbers(4,5,5))
        );
    }

    @DisplayName("야구 숫자 일급 콜렉션 투구 결과 테스트")
    @ParameterizedTest
    @MethodSource("provideComputerAndUserBallNumbers")
    void getPitchingResultStatusTest(BallNumbers computerBallNumbers,
                                     List<BallNumber> userBallNumbers,
                                     List<PitchingResultStatus> resultStatuses) {
        //given
        List<PitchingResultStatus> result = new ArrayList<>();
        int index = 0;

        //when
        for (BallNumber ballNumber : userBallNumbers) {
            result.add(computerBallNumbers.getPitchingResultStatus(ballNumber, index++));
        }

        //then
        assertThat(result.containsAll(resultStatuses)).isTrue();


    }

    private static Stream<Arguments> provideComputerAndUserBallNumbers() {
        return Stream.of(
                Arguments.of(new BallNumbers(getBallNumbers(1,2,3)), getBallNumbers(1,2,3), Arrays.asList(STRIKE,STRIKE,STRIKE)),
                Arguments.of(new BallNumbers(getBallNumbers(1,2,3)), getBallNumbers(3,2,1), Arrays.asList(BALL,BALL,BALL)),
                Arguments.of(new BallNumbers(getBallNumbers(5,7,9)), getBallNumbers(5,9,3), Arrays.asList(STRIKE,BALL,NOTHING))
        );
    }

    private static List<BallNumber> getBallNumbers(int... numbers) {
        List<BallNumber> ballNumbers = new ArrayList<>();
        for (int number : numbers) {
            ballNumbers.add(new BallNumber(number));
        }

        return ballNumbers;
    }
}
