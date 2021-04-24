import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
    private RandomGenerator randomGenerator;

    @BeforeEach
    public void beforeSet() {
        randomGenerator = new RandomGenerator(BaseballGame.DEFAULT_LEN);
    }

    @Test
    public void isValidatedLength() {
        String randomBalls = randomGenerator.generateBalls();
        Assertions.assertEquals(randomBalls.length(), BaseballGame.DEFAULT_LEN);
    }
}
