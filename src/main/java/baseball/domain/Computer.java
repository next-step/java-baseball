package baseball.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {

    private final static int CREATE_SIZE = 3;
    private final static int MAX_NUMBER = 9;

    public static ArrayList<Integer> createNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();

        while(numbers.size() < CREATE_SIZE) {
            numbers.add((int)(Math.random()*MAX_NUMBER)+1);
        }

        return new ArrayList<>(numbers);
    }
}
