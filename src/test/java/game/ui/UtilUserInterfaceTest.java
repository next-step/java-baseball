package game.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilUserInterfaceTest {

    @Test
    public void verifyEmptyInput_Then_Exception() {
        Throwable exception = assertThrows(Exception.class, () ->  {
            String userInput = "";
            UtilUserInterface.verifyValidInput(userInput);
        });

        assertEquals("아무것도 입력하지 않았습니다", exception.getMessage());
    }

    @Test
    public void verifyContainNonDigit_Then_Exception() {
        Throwable exception = assertThrows(Exception.class, () ->  {
            String userInput = "51a";
            UtilUserInterface.verifyValidInput(userInput);
        });

        assertEquals("숫자가 아닌 문자가 포함되었습니다", exception.getMessage());
    }
}