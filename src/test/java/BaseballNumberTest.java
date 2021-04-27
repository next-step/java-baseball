import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.BaseballNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseballNumberTest {
    BaseballNumber baseballNumber = new BaseballNumber();

    @Test
    @DisplayName("랜덤생성 숫자가 3자리인지 검사")
    void getBaseballNumberCountTest() {
        int[] getNumber = baseballNumber.getBaseballNumber();
        assertEquals(3, getNumber.length);
    }

    @Test
    @DisplayName("랜덤생성 숫자의 범위가 1~9인지 검사")
    void getBaseballNumberRangeTest() {
        int[] getNumber = baseballNumber.getBaseballNumber();
        for(int number : getNumber){
            assertTrue(number > 0 && number < 10);
        }
    }
}
