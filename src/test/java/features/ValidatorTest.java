package features;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ValidatorTest {

    @Test
    @DisplayName("Test validator using false input")
    void falseInputTest() {
        String[] testSet = {"441", "414", "024", "2", "33", "asdf", "123asdf", "!@#"};
        for (String test: testSet) {
            assertFalse(Validator.isCorrectInput(test));
        }
    }

    @Test
    @DisplayName("Test validator using correct input")
    void trueInputTest() {
        assertTrue(Validator.isCorrectInput("123"));
    }

    @Test
    @DisplayName("Test option validator using false input")
    void falseOptionTest() {
        String[] testSet = {"3", "asdf", "12", "@@"};
        for (String test: testSet) {
            assertFalse(Validator.isCorrectOption(test));
        }
    }

    @Test
    @DisplayName("Test option validator using correct input")
    void trueOptionTest() {
        assertAll(
                () -> assertTrue(Validator.isCorrectOption("1")),
                () -> assertTrue(Validator.isCorrectOption(("2"))));
    }

}