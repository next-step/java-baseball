import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckTest {
    Check check = new Check();

    @Test
    public void validationCheckTest() {
        assertTrue(check.validationCheck(123));
        assertTrue(check.validationCheck(987));
        assertTrue(check.validationCheck(239));
        assertTrue(check.validationCheck(912));
        assertTrue(check.validationCheck(586));

        assertFalse(check.validationCheck(111));
        assertFalse(check.validationCheck(939));
        assertFalse(check.validationCheck(206));
        assertFalse(check.validationCheck(13));
        assertFalse(check.validationCheck(1234));
    }
}
