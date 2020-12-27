package study;

import java.util.Set;
import java.util.HashSet;

public class MySet {
    private Set<Integer> set;

    public MySet() {
        set = new HashSet<>();
    }

    public void add(int value) {
        set.add(value);
    }

    public int size() {
        return set.size();
    }

    public boolean contains(int value) {
        return set.contains(value);
    }
}
