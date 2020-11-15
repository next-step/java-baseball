import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 9})
    void generateRandomNumber_IsBetweenOneAndNine(int number) {
        assertTrue(number >= 1 && number <= 9);
    }

    @Test
    void insertDifferentNumbers_IsDifferent() {
        int[] fNumbers = new int[]{1, 2, 3};
        int length = fNumbers.length;
        for(int i = 0; i < length*length ; i++ ) {
            int row = i / length;
            int col = i % length;
            if(row != col){
                assertTrue(fNumbers[row] != fNumbers[col]);
            }
        }
    }
}
