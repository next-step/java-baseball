import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Iterator;
import java.util.Set;

public class BaseballNumberTest {
    BaseballNumber baseballNumber = new BaseballNumber();

    @Test
    @DisplayName("랜덤생성 숫자가 3자리인지 검사")
    void getBaseballNumberCountTest() {
        Set<Integer> getNumber = baseballNumber.getBaseballNumber();
        assertEquals(3, getNumber.size());
    }

    @Test
    @DisplayName("랜덤생성 숫자의 범위가 1~9인지 검사")
    void getBaseballNumberRangeTest() {
        Set<Integer> getNumber = baseballNumber.getBaseballNumber();
        Iterator<Integer> numbers = getNumber.iterator();
        while(numbers.hasNext()) {
            Integer number = numbers.next();
            assertTrue(number > 0 && number < 10);
        }
    }
}
