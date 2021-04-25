package controller;

import domain.UserNumberInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    public void userInputTest(){

        UserController userController = new UserController();
        boolean chk = userController.generateUserNumberInfo(123);

        assertEquals(true, chk);
    }

    @Test
    public void userInputWrongTest(){
        UserController userController = new UserController();
        boolean chk = userController.generateUserNumberInfo(112);

        assertEquals(false, chk);
    }

}