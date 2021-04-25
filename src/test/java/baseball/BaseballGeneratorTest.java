package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGeneratorTest {


    @Test
    void 크기가_3인_BaseballNumber를_생성한다(){
        final int EXPECTED_SIZE = 3;
        BaseballNumber createdBaseballNumber = BaseballGenerator.apply();
        assertEquals(EXPECTED_SIZE, createdBaseballNumber.size());
    }
}