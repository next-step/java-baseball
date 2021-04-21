import java.util.Random;

public class RandomGenerator {

    private Random random = new Random();

    public int nextInt() {
        return random.nextInt(8) + 1;
    }
}
