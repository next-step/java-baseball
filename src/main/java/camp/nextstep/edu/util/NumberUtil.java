package camp.nextstep.edu.util;

import java.util.Random;

public class NumberUtil {

    private NumberUtil() {

    }

    public static int generateNumber(int bound) {
        return new Random().nextInt(bound);
    }
}
