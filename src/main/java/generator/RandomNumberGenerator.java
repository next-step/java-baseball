package generator;

import java.util.HashSet;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public Set<Integer> generate(int size) {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < size) {
            int random = (int)(Math.random() * 8) + 1;
            numbers.add(random);
        }
        return numbers;
    }
}
