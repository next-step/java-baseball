import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {

    @Test
    public void isEmptyTest() {
        String testVal = "123";
        String emptyVal = "";

        Validation validation = new Validation();

        boolean result = validation.isEmpty(testVal);
        assertThat(result).isFalse();

        boolean emptyValResult = validation.isEmpty(emptyVal);
        assertThat(emptyValResult).isTrue();

        boolean nullValResult = validation.isEmpty(null);
        assertThat(nullValResult).isTrue();
    }

    @Test
    public void isCorrectDigitTest() {
        String correctVal = "123";
        String inCorrectVal = "12345";

        Validation validation = new Validation();

        boolean correctValRes = validation.isInCorrectDigit(correctVal, 3);
        boolean inCorrectValRes = validation.isInCorrectDigit(inCorrectVal, 3);

        assertThat(correctValRes).isFalse();

        assertThat(inCorrectValRes).isTrue();
    }

    @Test
    public void isDuplicateTest() {
        String inputVal = "131";

        Validation validation = new Validation();
        boolean result = validation.isDuplicate(inputVal);

        assertThat(result).isTrue();
    }
}