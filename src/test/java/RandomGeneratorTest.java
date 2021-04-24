import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {
    private RandomGenerator randomGenerator;

    @Test
    public void beforeSet() {
        randomGenerator = new RandomGenerator(BaseballGame.DEFAULT_LEN);
    }
}
