package features;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    @DisplayName("Test validator using false input")
    void falseInputTest() {
        String[] testSet = {"441", "414", "024", "2", "33", "asdf", "123asdf"};
        for (String test: testSet) {
            assertFalse(Validator.isCorrectInput(test));
        }
    }

    @Test
    @DisplayName("Test validator using correct input")
    void trueInputTest() {
        assertTrue(Validator.isCorrectInput("123"));
    }

}