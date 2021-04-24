package baseball.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {

    private final static int CREATE_SIZE = 3;
    private final static int MAX_NUMBER = 3;

    public static Set<Integer> createNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();

        while(numbers.size() < CREATE_SIZE) {
            numbers.add((int)(Math.random()*MAX_NUMBER)+1);
        }

        return numbers;
    }
}
