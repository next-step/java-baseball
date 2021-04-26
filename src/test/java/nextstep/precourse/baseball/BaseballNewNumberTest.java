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
        Set<Integer> newRandomSet = baseballNewNumber.newRandomNumber();

        assertEquals(newRandomSet.size(), 3);

        assertFalse(newRandomSet.contains(0));
    }

}