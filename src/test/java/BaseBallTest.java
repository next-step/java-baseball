import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {

    BaseBall baseBall = new BaseBall();

    @Test
    void generateRandomNumber_IsBetweenOneAndNine() {
        int number = baseBall.generateRandomNumber();
        assertTrue(number >= 1 && number <= 9);
    }

    @Test
    void insertDifferentNumbers_IsDifferent() {
        while(baseBall.numberSet.size() < 3) {
            baseBall.insertDifferentNumbers(baseBall.generateRandomNumber());
        }
        int length = baseBall.computerNumbers.length;
        for(int i = 0; i < length * length; i++ ) {
            int row = i / length;
            int col = i % length;
            if(row != col){
                assertTrue(baseBall.computerNumbers[row] != baseBall.computerNumbers[col]);
            }
        }
    }

    @Test
    @DisplayName("입력 자리수는 최대 3자리다.")
    void insertInputNumber() {
        assertThatThrownBy(() -> baseBall.insertInputNumber(3456))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index -1 out of bounds for length 3"); // jdk 버전, openjdk 마다 다름
    }

    @Test
    void compareNumbers() {
        baseBall.computerNumbers = new int[] {7, 5, 9};
        baseBall.playerNumbers = new int[] {5, 9, 1};
        for (int i = 0; i < 3; i++) {
            baseBall.compareNumbers(i, 0);
        }
        assertTrue(baseBall.strike == 0 && baseBall.ball == 2);
    }

    @Test
    void getHintMessage_isNothing() {
        assertThat(baseBall.getHintMessage()).contains("낫싱");
    }

    @Test
    void getHintMessage_isStrikeAndBall() {
        baseBall.strike = 1;
        baseBall.ball = 2;
        assertThat(baseBall.getHintMessage()).contains("볼", "스트라이크");
    }

    @Test
    void getHintMessage_isNotEmpty() {
        assertThat(baseBall.getHintMessage()).isNotEmpty();
    }

    @Test
    void play() {
        baseBall.computerNumbers = new int[] {7, 1, 3};
        baseBall.insertInputNumber(123);
        compareNumbers();
        assertThat(baseBall.getHintMessage()).contains("스트라이크", "볼");

        baseBall.initUser();
        baseBall.insertInputNumber(145);
        compareNumbers();
        assertThat(baseBall.getHintMessage()).contains("볼");

        baseBall.initUser();
        baseBall.insertInputNumber(671);
        compareNumbers();
        assertThat(baseBall.getHintMessage()).contains("볼");

        baseBall.initUser();
        baseBall.insertInputNumber(216);
        compareNumbers();
        assertThat(baseBall.getHintMessage()).contains("스트라이크");

        baseBall.initUser();
        baseBall.insertInputNumber(713);
        compareNumbers();
        assertThat(baseBall.getHintMessage()).contains("3 스트라이크");
    }

}
