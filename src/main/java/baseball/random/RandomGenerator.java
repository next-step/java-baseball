package baseball.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomGenerator implements Random {
    private final List<String> list = new ArrayList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    @Override
    public List<String> shuffle(List list) {
        final List<String> copiedList = new ArrayList(list);
        Collections.shuffle(copiedList);
        return copiedList;
    }
}
