import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberUtilTest {

    @Test
    void isSuitableNumber() {
        NumberUtil numberUtil = new NumberUtil();
        assertEquals(numberUtil.isSuitableNumber("123"), true);
        assertEquals(numberUtil.isSuitableNumber("012"), false);
        assertEquals(numberUtil.isSuitableNumber("ab1"), false);
        assertEquals(numberUtil.isSuitableNumber("112"), false);
        assertEquals(numberUtil.isSuitableNumber("1234"), false);
    }
}