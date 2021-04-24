import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class RandomGeneratorTest {
    private RandomGenerator randomGenerator;
    private String randomBalls;

    @BeforeEach
    public void beforeSet() {
        randomGenerator = new RandomGenerator(BaseballGame.DEFAULT_LEN);
        randomBalls = randomGenerator.generateBalls();
    }

    @Test
    public void isValidatedLength() {
        Assertions.assertEquals(randomBalls.length(), BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void isValidatedDigit() {
        for (int i=0; i<randomBalls.length(); i++) {
            int num = randomBalls.charAt(i) - '0';
            Assertions.assertEquals(Pattern.matches("^[1-9]", randomBalls.charAt(i) + ""), true );
        }
    }
}
