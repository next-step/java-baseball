package service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseServiceTest {
    BaseService baseService = new BaseServiceImpl();


    @Test
    void resultCheckTest() {
        boolean check = baseService.resultCheck(3,0);
        boolean result = false;

        assertEquals(result, check);
    }

    @Test
    void playChoiceTest() {
        boolean check = baseService.playChoice("2");
        boolean result = true;

        assertEquals(result, check);
    }
}
