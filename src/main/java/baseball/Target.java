package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Target {

    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    final List<Integer> value;

    public Target() {
        List<Integer> v = new ArrayList<>();
        v.add(getUnique(v));
        v.add(getUnique(v));
        v.add(getUnique(v));
        value = v;
    }

    static int getUnique(List<Integer> v) {
        int i = RANDOM.nextInt(1, 10);
        while (v.contains(i)) {
            i = RANDOM.nextInt(1, 10);
        }
        return i;
    }
}
