import domain.BaseballNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseballNumberGeneratorTest {
    @Test
    public void generateRandomNumber() throws Exception {
        List<Integer> baseballNumbers = BaseballNumberGenerator.generateBaseballNumbers();

        for (int baseballNumber : baseballNumbers) {
            System.out.println(baseballNumber);
        }
    }
}
