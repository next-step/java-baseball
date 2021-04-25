package baseball;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class NumberGenerator {
    private final Random random;
    private static final int NUMBER_SIZE = 3;
    private static final int MAX_NUMBER = 9;

    public NumberGenerator() {
        this.random = new Random();
    }

    public String generate() {
        return convertAsString(generateIntList(NUMBER_SIZE));
    }

    private SortedSet<Integer> generateIntList(int size) {
        SortedSet<Integer> list = new TreeSet<>();
        while(list.size() < size) {
            Integer number = random.nextInt(MAX_NUMBER) + 1;
            list.add(number);
        }
        return list;
    }

    private String convertAsString(SortedSet<Integer> number) {
        StringBuilder sb = new StringBuilder();

        for (Integer ch : number) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
