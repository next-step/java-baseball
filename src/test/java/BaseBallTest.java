import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
