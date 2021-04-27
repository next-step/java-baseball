package baseball.service;

import baseball.domain.BallNumber;
import baseball.domain.BallNumbers;
import baseball.domain.PitchingResultStatus;
import baseball.domain.dto.BaseballResultResponse;
import baseball.strategy.BaseballTestGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static baseball.data.TestBall.*;
import static baseball.domain.PitchingResultStatus.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BaseballService 클래스 기능 관련 테스트")
class BaseballServiceTest {
    private BaseballService baseballService;
    private BaseballTestGenerator generator;

    @BeforeEach
    void setup() {
        generator = new BaseballTestGenerator();
        baseballService = new BaseballService(generator);
    }

    @DisplayName("야구숫자 생성 전략으로 생성한 야구숫자 일급 콜렉션 테스트")
    @ParameterizedTest
    @MethodSource("provideBallNumbersAndResult")
    void generateComputedNumbersTest(List<BallNumber> numbers) {
        //given
        generator.setBallNumbers(numbers);

        //when
        BallNumbers ballNumbers = baseballService.generateComputedNumbers();

        //then
        assertThat(ballNumbers.size()).isEqualTo(3);
        assertThat(ballNumbers.containsAll(numbers)).isTrue();
    }

    private static Stream<Arguments> provideBallNumbersAndResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(ONE, TWO, THREE))
        );
    }



    @DisplayName("두 야구숫자 일급 콜렉션을 비교하면 비교결과 응답객체가 반환된다.")
    @ParameterizedTest
    @MethodSource("provideComputedNumbersAndUserNumbers")
    void matchesBallNumbersTest(List<Integer> userNumbers,
                                boolean allStrike,
                                Map<PitchingResultStatus, Integer> resultMap) {

        //given
        BallNumbers computedNumbers = BallNumbers.of(Arrays.asList(1,2,3));


        //when
        BaseballResultResponse response = baseballService.matchesBallNumbers(computedNumbers, userNumbers);

        //then
        assertThat(response.isAllStrike()).isEqualTo(allStrike);
        assertThat(response.getPitchingResult()).containsAllEntriesOf(resultMap);

    }

    private static Stream<Arguments> provideComputedNumbersAndUserNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3), true, createResultParamMap(3,0,0)),
                Arguments.of(Arrays.asList(2,5,3), false, createResultParamMap(1,1,1)),
                Arguments.of(Arrays.asList(5,4,1), false, createResultParamMap(0,1,2))
        );
    }

    private static Map createResultParamMap(int strikeCount, int ballCount, int nothingCount) {
        return new EnumMap<PitchingResultStatus, Integer>(PitchingResultStatus.class){{
            put(STRIKE, strikeCount);
            put(BALL, ballCount);
            put(NOTHING, nothingCount);
        }};
    }

}
