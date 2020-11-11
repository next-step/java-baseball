import java.util.Random;

public final class NumberGenerator {

    private static final Random random = new Random(System.nanoTime());

    public static int[] generate() {
        return new int[] { random(), random(), random()};
    }

    private static int random() {
        return random.nextInt(9) + 1;
    }

    private NumberGenerator() {}
}
