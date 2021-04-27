package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class playGameTest {

    @Test
    public void checkInputTest(){
        //given
        String wrongInput1 = "4423";
        String wrongInput2 = "12";
        String wrongInput3 = "가나다";
        String wrongInput4 = "1가나";
        String rightInput = "423";

        //when
        boolean isRightNumber = PlayGame.checkInput(wrongInput1);
        //then
        assertFalse(isRightNumber);

        //when
        isRightNumber = PlayGame.checkInput(wrongInput1);
        //then
        assertFalse(isRightNumber);

        //when
        isRightNumber = PlayGame.checkInput(wrongInput2);
        //then
        assertFalse(isRightNumber);

        //when
        isRightNumber = PlayGame.checkInput(wrongInput3);
        //then
        assertFalse(isRightNumber);

        //when
        isRightNumber = PlayGame.checkInput(wrongInput4);
        //then
        assertFalse(isRightNumber);

        //when
        isRightNumber = PlayGame.checkInput(rightInput);
        //then
        assertTrue(isRightNumber);
    }



}