package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    private Score score;

    @BeforeEach
    void setup() {
        score = new Score();
    }

    @DisplayName("add strike")
    @ParameterizedTest
    @CsvSource(value = {"2:2", "10:10"}, delimiter = ':')
    void addStrike(int count, int expected) {
        for (int i = 0; i < count; i++) {
            score.addStrike();
        }
        assertThat(score.getStrike()).isEqualTo(expected);
    }

    @DisplayName("add ball")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "4:4"}, delimiter = ':')
    void addBall(int count, int expected) {
        for (int i = 0; i < count; i++) {
            score.addBall();
        }
        assertThat(score.getBall()).isEqualTo(expected);
    }

    @DisplayName("낫싱 판단")
    @ParameterizedTest
    @CsvSource(value = {"2:false", "0:true"}, delimiter = ':')
    void isNothing(int count, boolean expected) {
        for (int i = 0; i < count; i++) {
            score.addStrike();
        }
        assertThat(score.isNothing()).isEqualTo(expected);
    }
}