import java.util.Random;

public class RandomGenerator {

    private final Random random = new Random();

    public int nextInt() {
        return random.nextInt(8) + 1;
    }
}
