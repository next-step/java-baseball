package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNumberUtilTest {

    @Test
    public void numberTest(){
        boolean checkNumber = UserNumberUtil.checkNumberDigit(123);
        assertEquals(true, checkNumber);
    }

    @Test
    public void zeroNumberTest(){
        boolean checkNumber = UserNumberUtil.checkNumberNonZero(120);
        assertEquals(false, checkNumber);
    }

}