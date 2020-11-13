package baseball.service;

import baseball.domain.GameNumber;
import baseball.domain.GameNumberPackage;
import baseball.domain.InputNumbers;
import baseball.domain.NumberResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TrialResultCalculatorTest {
    private static Map<GameNumber, Integer> testPackage = new HashMap<>();
    private static GameNumberPackage gameNumberPackage;

    @BeforeAll
    static void beforeAll() {
        testPackage.put(GameNumber.getInstance(1), 0);
        testPackage.put(GameNumber.getInstance(2), 1);
        testPackage.put(GameNumber.getInstance(3), 2);

        gameNumberPackage = new GameNumberPackage(testPackage);
    }

    static Stream<Arguments> generateNothingData() {
        return Stream.of(
            Arguments.of(getInputNumbers(Arrays.asList(4, 5, 6))),
            Arguments.of(getInputNumbers(Arrays.asList(7, 8, 9)))
        );
    }

    static Stream<Arguments> generateOneStrikeData() {
        return Stream.of(
            Arguments.of(getInputNumbers(Arrays.asList(1, 4, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 6, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 8, 9))),

            Arguments.of(getInputNumbers(Arrays.asList(4, 2, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 2, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 2, 9))),

            Arguments.of(getInputNumbers(Arrays.asList(4, 5, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 7, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 9, 3)))
        );
    }

    static Stream<Arguments> generateOneBallData() {
        return Stream.of(
            Arguments.of(getInputNumbers(Arrays.asList(4, 1, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 1, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 1, 9))),

            Arguments.of(getInputNumbers(Arrays.asList(4, 5, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 7, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 9, 1))),

            Arguments.of(getInputNumbers(Arrays.asList(2, 4, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(2, 6, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(2, 8, 9))),

            Arguments.of(getInputNumbers(Arrays.asList(4, 5, 2))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 7, 2))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 9, 2))),

            Arguments.of(getInputNumbers(Arrays.asList(3, 4, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 6, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 8, 9))),

            Arguments.of(getInputNumbers(Arrays.asList(4, 3, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 3, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 3, 9)))
        );
    }

    static Stream<Arguments> generateOneStrikeOneBallData() {
        return Stream.of(
            Arguments.of(getInputNumbers(Arrays.asList(1, 4, 2))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 5, 2))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 6, 2))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 7, 2))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 8, 2))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 9, 2))),

            Arguments.of(getInputNumbers(Arrays.asList(1, 3, 4))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 3, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 3, 6))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 3, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 3, 8))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 3, 9))),

            Arguments.of(getInputNumbers(Arrays.asList(4, 2, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(5, 2, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 2, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(7, 2, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 2, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(9, 2, 1))),

            Arguments.of(getInputNumbers(Arrays.asList(3, 2, 4))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 2, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 2, 6))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 2, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 2, 8))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 2, 9))),

            Arguments.of(getInputNumbers(Arrays.asList(4, 1, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(5, 1, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 1, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(7, 1, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 1, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(9, 1, 3))),

            Arguments.of(getInputNumbers(Arrays.asList(2, 4, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(2, 5, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(2, 6, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(2, 7, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(2, 8, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(2, 9, 3)))
        );
    }

    static Stream<Arguments> generateOneStrikeTwoBallsData() {
        return Stream.of(
            Arguments.of(getInputNumbers(Arrays.asList(1, 3, 2))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 2, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(2, 1, 3)))
        );
    }

    static Stream<Arguments> generateTwoStrikesData() {
        return Stream.of(
            Arguments.of(getInputNumbers(Arrays.asList(1, 2, 4))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 2, 5))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 2, 6))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 2, 7))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 2, 8))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 2, 9))),

            Arguments.of(getInputNumbers(Arrays.asList(1, 4, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 5, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 6, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 7, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 8, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(1, 9, 3))),

            Arguments.of(getInputNumbers(Arrays.asList(4, 2, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(5, 2, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(6, 2, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(7, 2, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(8, 2, 3))),
            Arguments.of(getInputNumbers(Arrays.asList(9, 2, 3)))
        );
    }

    static Stream<Arguments> generateThreeBallsData() {
        return Stream.of(
            Arguments.of(getInputNumbers(Arrays.asList(2, 3, 1))),
            Arguments.of(getInputNumbers(Arrays.asList(3, 1, 2)))
        );
    }

    static Stream<Arguments> generateThreeStrikesData() {
        return Stream.of(
            Arguments.of(getInputNumbers(Arrays.asList(1, 2, 3)))
        );
    }

    private static Set<GameNumber> getInputNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(GameNumber::getInstance)
            .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @DisplayName("getOrDefault() - Nothing 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - numbers={0}")
    @MethodSource("generateNothingData")
    void getOrDefaultForNothing(Set<GameNumber> inputNumbers) {
        TrialResultCalculator resultCalculator = new TrialResultCalculator(gameNumberPackage, new InputNumbers(inputNumbers));

        assertThat(resultCalculator.getOrDefault(NumberResult.STRIKE, 0)).isEqualTo(0);
        assertThat(resultCalculator.getOrDefault(NumberResult.BALL, 0)).isEqualTo(0);
    }

    @DisplayName("getOrDefault() - 1 Strike 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - numbers={0}")
    @MethodSource("generateOneStrikeData")
    void getOrDefaultForOneStrike(Set<GameNumber> inputNumbers) {
        TrialResultCalculator resultCalculator = new TrialResultCalculator(gameNumberPackage, new InputNumbers(inputNumbers));

        assertThat(resultCalculator.getOrDefault(NumberResult.STRIKE, 0)).isEqualTo(1);
        assertThat(resultCalculator.getOrDefault(NumberResult.BALL, 0)).isEqualTo(0);
    }

    @DisplayName("getOrDefault() - 1 Ball 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - numbers={0}")
    @MethodSource("generateOneBallData")
    void getOrDefaultForOneBall(Set<GameNumber> inputNumbers) {
        TrialResultCalculator resultCalculator = new TrialResultCalculator(gameNumberPackage, new InputNumbers(inputNumbers));

        assertThat(resultCalculator.getOrDefault(NumberResult.STRIKE, 0)).isEqualTo(0);
        assertThat(resultCalculator.getOrDefault(NumberResult.BALL, 0)).isEqualTo(1);
    }

    @DisplayName("getOrDefault() - 1 Strike, 1 Ball 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - numbers={0}")
    @MethodSource("generateOneStrikeOneBallData")
    void getOrDefaultForOneStrikeOneBall(Set<GameNumber> inputNumbers) {
        TrialResultCalculator resultCalculator = new TrialResultCalculator(gameNumberPackage, new InputNumbers(inputNumbers));

        assertThat(resultCalculator.getOrDefault(NumberResult.STRIKE, 0)).isEqualTo(1);
        assertThat(resultCalculator.getOrDefault(NumberResult.BALL, 0)).isEqualTo(1);
    }

    @DisplayName("getOrDefault() - 1 Strike, 2 Ball 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - numbers={0}")
    @MethodSource("generateOneStrikeTwoBallsData")
    void getOrDefaultForOneStrikeTwoBalls(Set<GameNumber> inputNumbers) {
        TrialResultCalculator resultCalculator = new TrialResultCalculator(gameNumberPackage, new InputNumbers(inputNumbers));

        assertThat(resultCalculator.getOrDefault(NumberResult.STRIKE, 0)).isEqualTo(1);
        assertThat(resultCalculator.getOrDefault(NumberResult.BALL, 0)).isEqualTo(2);
    }

    @DisplayName("getOrDefault() - 2 Strike 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - numbers={0}")
    @MethodSource("generateTwoStrikesData")
    void getOrDefaultForTwoStrikes(Set<GameNumber> inputNumbers) {
        TrialResultCalculator resultCalculator = new TrialResultCalculator(gameNumberPackage, new InputNumbers(inputNumbers));

        assertThat(resultCalculator.getOrDefault(NumberResult.STRIKE, 0)).isEqualTo(2);
        assertThat(resultCalculator.getOrDefault(NumberResult.BALL, 0)).isEqualTo(0);
    }

    @DisplayName("getOrDefault() - 3 Ball 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - numbers={0}")
    @MethodSource("generateThreeBallsData")
    void getOrDefaultForThreeBalls(Set<GameNumber> inputNumbers) {
        TrialResultCalculator resultCalculator = new TrialResultCalculator(gameNumberPackage, new InputNumbers(inputNumbers));

        assertThat(resultCalculator.getOrDefault(NumberResult.STRIKE, 0)).isEqualTo(0);
        assertThat(resultCalculator.getOrDefault(NumberResult.BALL, 0)).isEqualTo(3);
    }

    @DisplayName("getOrDefault() - 3 Strike 케이스 테스트")
    @ParameterizedTest(name = "({index}) {displayName} - numbers={0}")
    @MethodSource("generateThreeStrikesData")
    void getOrDefaultForThreeStrikes(Set<GameNumber> inputNumbers) {
        TrialResultCalculator resultCalculator = new TrialResultCalculator(gameNumberPackage, new InputNumbers(inputNumbers));

        assertThat(resultCalculator.getOrDefault(NumberResult.STRIKE, 0)).isEqualTo(3);
        assertThat(resultCalculator.getOrDefault(NumberResult.BALL, 0)).isEqualTo(0);
    }
}