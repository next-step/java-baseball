import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class UserInputTest {

    @Test
    public void userMustInputInteger() throws Exception{
        //given
        UserInput userInput = new UserInput();
        Integer inputNumber;

        //when
        inputNumber = userInput.setAndGetInputNumber();
        //then
        Assertions.assertSame(inputNumber.TYPE, Integer.TYPE);
    }
}
