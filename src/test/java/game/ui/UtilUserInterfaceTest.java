package game.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilUserInterfaceTest {

    @Test
    public void verifyEmptyInput_Then_Exception() {
        Throwable exception = assertThrows(Exception.class, () ->  {
            String userInput = "";
            UtilUserInterface.verifyCommonCondition(userInput);
        });

        assertEquals("아무것도 입력하지 않았습니다", exception.getMessage());
    }

    @Test
    public void verifyContainNonDigit_Then_Exception() {
        Throwable exception = assertThrows(Exception.class, () ->  {
            String userInput = "51a";
            UtilUserInterface.verifyCommonCondition(userInput);
        });

        assertEquals("숫자가 아닌 문자가 포함되었습니다", exception.getMessage());
    }

    @Test
    public void verifyNotLengthThree_Then_Exception() {
        Throwable exception = assertThrows(Exception.class, () ->  {
            String userInput = "51";
            UtilUserInterface.verifyValidInput(UserInterface.PITCH, userInput);
        });

        assertEquals("3자리 숫자가 아닙니다", exception.getMessage());
    }

    @Test
    public void verifyContainDuplicatedDigit_Then_Exception() {
        Throwable exception = assertThrows(Exception.class, () ->  {
            String userInput = "511";
            UtilUserInterface.verifyValidInput(UserInterface.PITCH, userInput);
        });

        assertEquals("숫자가 중복되었습니다", exception.getMessage());
    }

    @Test
    public void verifyContainNonOptionalDigit_Then_Exception() {
        Throwable exception = assertThrows(Exception.class, () ->  {
            String userInput = "5";
            UtilUserInterface.verifyValidInput(UserInterface.ASK_FINISH, userInput);
        });

        assertEquals("1 또는 2가 아닙니다", exception.getMessage());
    }
}