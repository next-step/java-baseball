package computer;

import baseball.BaseballConstants;
import baseball.BaseballNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomBaseballGeneratorTest {

    @Test
    void BASEBALL_NUMBER_SIZE_크기의_BaseballNumber를_생성한다(){
        BaseballNumbers createdBaseballNumbers = RandomBaseballGenerator.apply();
        assertEquals(BaseballConstants.BASEBALL_NUMBER_SIZE, createdBaseballNumbers.size());
    }
}