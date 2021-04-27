import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicTest {

    private Random random;
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        random = new Random();
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void randomNumberRangeTest() {
        int randomValue = random.nextInt(8) + 1;
        assertThat(randomValue > 0 && randomValue < 10);
    }

    @Test
    void hundredIntValueToList(){
        List<Integer> result = new ArrayList<>();
        int userInput = 527;
        int modifyNumber = 100;
        do {
            int value = userInput / modifyNumber;
            userInput %= modifyNumber;
            modifyNumber /= 10;
            result.add(value);
        } while (modifyNumber != 0);
        assertThat(result.size() == 3);
        assertThat(result.get(0) == userInput % 100);
    }


}
