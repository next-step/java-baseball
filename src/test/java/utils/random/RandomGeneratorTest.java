package utils.random;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static game.baseball.constant.BaseballConfig.*;
import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    void integerListGeneratorNotDuplicate() {
        List<Integer> randomNumberList
                = RandomGenerator.integerListGeneratorNotDuplicate(ANSWER_COUNT, ANSWER_NUMBER_MIN, ANSWER_NUMBER_MAX);

        assertEquals(ANSWER_COUNT, randomNumberList.size());
        assertEquals(ANSWER_COUNT, new HashSet<>(randomNumberList).size());
        for (Integer integer : randomNumberList) {
            assertTrue(validateNumberBoundary(integer));
        }
    }

    private boolean validateNumberBoundary(Integer integer) {
        return integer >= ANSWER_NUMBER_MIN && integer <= ANSWER_NUMBER_MAX;
    }
}
