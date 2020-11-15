package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MatchMachineTest {
    private MatchMachine matchMachine;

    @BeforeEach
    void setup() {
        List<Integer> computerNumbers = new ArrayList<>();
        computerNumbers.add(1);
        computerNumbers.add(2);
        computerNumbers.add(3);
        matchMachine = new MatchMachine(computerNumbers);
    }

    @DisplayName("Strike check")
    @ParameterizedTest
    @MethodSource("provideBaseballNumbers1")
    void compareStrike(List<Integer> numbers, int expected) {
        Score score = matchMachine.compare(numbers);
        assertThat(score.getStrike()).isEqualTo(expected);
    }

    @DisplayName("Ball check")
    @ParameterizedTest
    @MethodSource("provideBaseballNumbers2")
    void compareBall(List<Integer> numbers, int expected) {
        Score score = matchMachine.compare(numbers);
        assertThat(score.getBall()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideBaseballNumbers1() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 4, 5), 1),
                Arguments.of(Arrays.asList(3, 1, 2), 0),
                Arguments.of(Arrays.asList(1, 6, 3), 2)
        );
    }

    private static Stream<Arguments> provideBaseballNumbers2() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 4, 5), 1),
                Arguments.of(Arrays.asList(3, 1, 2), 3),
                Arguments.of(Arrays.asList(5, 6, 7), 0)
        );
    }
}
