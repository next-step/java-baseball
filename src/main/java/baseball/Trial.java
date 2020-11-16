package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trial {
    List<Integer> value;

    public Trial(List<Integer> value) {
        this.value = value;
    }

    public static Trial of(String trialSource) {
        List<Integer> v = new ArrayList<>();
        String[] split = trialSource.split("");

        for (String s : split) {
            v.add(toInteger(s));
        }
        checkSize(v);
        checkDup(v);
        return new Trial(v);
    }

    private static void checkDup(List<Integer> v) {
        final Set<Integer> set = new HashSet<>(v);
        if (set.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkSize(List<Integer> v) {
        if (v.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static int toInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
