package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MatchMachineTest {
    private MatchMachine matchMachine;

    @BeforeEach
    void setup() {
        matchMachine = new MatchMachine("123");
    }

    @DisplayName("Strike check")
    @ParameterizedTest
    @CsvSource(value = {"145:1", "312:0", "163:2"}, delimiter = ':')
    void compareStrike(String number, int expected) {
        Score score = matchMachine.compare(number);
        assertThat(score.getStrike()).isEqualTo(expected);
    }

    @DisplayName("Ball check")
    @ParameterizedTest
    @CsvSource(value = {"345:1", "312:3", "567:0"}, delimiter = ':')
    void compareBall(String number, int expected) {
        Score score = matchMachine.compare(number);
        assertThat(score.getBall()).isEqualTo(expected);
    }
}
