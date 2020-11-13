package generator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int[] generate(int size) {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < size) {
            int random = (int)(Math.random() * 8) + 1;
            numbers.add(random);
        }
        return setToArray(numbers);
    }

    private int[] setToArray(Set<Integer> set) {
        int[] result = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index=0;
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }
        return result;
    }
}
