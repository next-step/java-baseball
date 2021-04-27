package playball.util;

import java.util.Random;

public class NumberGenerator {

    private static final Random random = new Random();

    public static Integer generateNumbers(Integer upperBound) {
        return random.nextInt(upperBound);
    }
}
