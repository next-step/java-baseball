package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    private String answer = "456";

    @ParameterizedTest
    @CsvSource({"456,true", "123,true", "212515,false", "12, false"})
    void LengthValid(String input, boolean expected) {
        boolean isValid = false;
        if(input.length() == 3){
            isValid = true;
        }
        assertEquals(expected, isValid);
    }

    @ParameterizedTest
    @CsvSource({"456,true", "fsd,false", "45d,false"})
    void inputStringValid(String input, boolean expected) {
        assertEquals(expected,isNumeric(input));
    }

    @ParameterizedTest
    @CsvSource({"456,3", "123,0", "457,2"})
    void checkStrike(String input, int expected) {
        int strike = 0;
        for (int i = 0; i < input.length(); i++) {
            char cInput = input.charAt(i);
            char cAnswer = answer.charAt(i);
            if (cInput == cAnswer) {
                strike++;
            }
        }
        assertEquals(expected, strike);
    }

    @ParameterizedTest
    @CsvSource({"645,3", "123,0", "745,2"})
    void checkBall(String input, int expected) {
        int ball = 0;
        for (int i = 0; i < input.length(); i++) {
            char cInput = input.charAt(i);
            if (answer.contains(Character.toString(cInput))) {
                ball++;
            }
        }
        assertEquals(expected, ball);
    }

}
