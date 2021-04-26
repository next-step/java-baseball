package nextstep.precourse.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BaseballNewNumberTest {

    BaseballNewNumber baseballNewNumber = new BaseballNewNumber();

    @Test
    void createNewRandom() {
        baseballNewNumber.newRandomNumber();

        Set<Integer> newRandomSet = baseballNewNumber.newRightNumber;

        assertEquals(newRandomSet.size(), 3);

        assertFalse(newRandomSet.contains(0));
    }

    @Test
    void createRandomArray() {
        int[] randomArray = baseballNewNumber.randomNumberArrayInput();
        Set<Integer> newRandomSet = baseballNewNumber.newRightNumber;

        assertEquals(randomArray.length, newRandomSet.size());

        for(int randomNumber : randomArray) {
            assertTrue(newRandomSet.contains(randomNumber));
        }
    }

}