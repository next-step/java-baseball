package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    private ResultGame resultGame;

    @BeforeEach
    void setup() {
        resultGame = new ResultGame();
    }

//    @DisplayName("add strike")
//    @ParameterizedTest
//    @CsvSource(value = {"2:2", "10:10"}, delimiter = ':')
//    void addStrike(int count, int expected) {
//        for (int i = 0; i < count; i++) {
//            resultGame.addStrike();
//        }
//        assertThat(resultGame.getStrike()).isEqualTo(expected);
//    }
//
//    @DisplayName("add ball")
//    @ParameterizedTest
//    @CsvSource(value = {"1:1", "4:4"}, delimiter = ':')
//    void addBall(int count, int expected) {
//        for (int i = 0; i < count; i++) {
//            resultGame.addBall();
//        }
//        assertThat(resultGame.getBall()).isEqualTo(expected);
//    }
//
//    @DisplayName("낫싱 판단")
//    @ParameterizedTest
//    @CsvSource(value = {"2:false", "0:true"}, delimiter = ':')
//    void isNothing(int count, boolean expected) {
//        for (int i = 0; i < count; i++) {
//            resultGame.addStrike();
//        }
//        assertThat(resultGame.isNothing()).isEqualTo(expected);
//    }
//
//    @DisplayName("모든 숫자가 일치")
//    @ParameterizedTest
//    @CsvSource(value = {"3:true", "1:false"}, delimiter = ':')
//    void isAllStrike(int count, boolean expected) {
//        for (int i = 0; i < count; i++) {
//            resultGame.addStrike();
//        }
//        assertThat(resultGame.isAllStrike()).isEqualTo(expected);
//    }
}